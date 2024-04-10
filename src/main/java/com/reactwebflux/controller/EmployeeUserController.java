package com.reactwebflux.controller;

import java.time.Duration;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reactwebflux.entity.EmployeeUser;
import com.reactwebflux.service.EmployeeUserService;

import io.swagger.v3.oas.annotations.Parameter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/react")
public class EmployeeUserController {

	@Autowired
	private EmployeeUserService employeeUserService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<EmployeeUser> create(@RequestBody EmployeeUser employeeUser) {
		return employeeUserService.createEmployeeUser(employeeUser);
	}

	@GetMapping("/getAll")
	public Flux<EmployeeUser> getAllEmployeeUser() {
		return employeeUserService.getAllUsers();
	}

	@GetMapping("/{employeeUserId}")
	public Mono<ResponseEntity<EmployeeUser>> getEmployeeUserById(@PathVariable int employeeUserId) {
		Mono<EmployeeUser> user = employeeUserService.findById(employeeUserId);
		return user.map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PutMapping("/{employeeUserId}")
	public Mono<ResponseEntity<EmployeeUser>> updateEmployeeUserById(@Parameter(description = "ID of the employee user") @PathVariable int employeeUserId,
			@RequestBody EmployeeUser user) {
		return employeeUserService.updateUser(employeeUserId, user).map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.badRequest().build());
	}

	@DeleteMapping("/{employeeUserId}")
	public Mono<ResponseEntity<Void>> deleteEmployeeUserById(@Parameter(description = "ID of the employee user") @PathVariable int employeeUserId) {
		return employeeUserService.deleteUser(employeeUserId).map(r -> ResponseEntity.ok().<Void>build())
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping("/search")
	public Flux<EmployeeUser> searchEmployeeUser(@RequestParam("name") String name) {
		return employeeUserService.fetchUsers(name);
	}
	//This is still not working, if i done database changes in the database or with end points or with other apps,
	//then updated values are not reflecting in the Stream, this has to fix. for time being I will check later this : 10/04/2024
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<EmployeeUser> streamAllEmployeeUser() {
		return employeeUserService.getAllUsers()
				.flatMap(user -> Flux
						.zip(Flux.interval(Duration.ofSeconds(2)), Flux.fromStream(Stream.generate(() -> user)))
						.map(Tuple2::getT2));
	}
}
