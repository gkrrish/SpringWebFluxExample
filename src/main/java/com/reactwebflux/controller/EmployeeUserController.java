package com.reactwebflux.controller;
/*
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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2; */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reactwebflux.entity.EmployeeUser;
import com.reactwebflux.service.EmployeeUserService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/react")
public class EmployeeUserController {
	
	private final EmployeeUserService employeeUserService;

	@Autowired
	public EmployeeUserController(EmployeeUserService employeeUserService) {
		this.employeeUserService = employeeUserService;
	}
	
	@GetMapping("/test")
	public String test() {
		return "Test";
	}

	
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<EmployeeUser> create(@RequestBody EmployeeUser employeeUser) {
		return employeeUserService.createEmployeeUser(employeeUser);
	}
	/*
	@GetMapping
	public Flux<EmployeeUser> getAllEmployeeUser() {
		return employeeUserService.getAllUsers();
	}

	@GetMapping("/{employeeUserId}")
	public Mono<ResponseEntity<EmployeeUser>> getEmployeeUserById(@PathVariable int userId) {
		Mono<EmployeeUser> user = employeeUserService.findById(userId);
		return user.map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PutMapping("/{employeeUserId}")
	public Mono<ResponseEntity<EmployeeUser>> updateEmployeeUserById(@PathVariable int userId,
			@RequestBody EmployeeUser user) {
		return employeeUserService.updateUser(userId, user).map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.badRequest().build());
	}

	@DeleteMapping("/{employeeUserId}")
	public Mono<ResponseEntity<Void>> deleteEmployeeUserById(@PathVariable int userId) {
		return employeeUserService.deleteUser(userId).map(r -> ResponseEntity.ok().<Void>build())
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping("/search")
	public Flux<EmployeeUser> searchEmployeeUser(@RequestParam("name") String name) {
		return employeeUserService.fetchUsers(name);
	}

	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<EmployeeUser> streamAllEmployeeUser() {
		return employeeUserService.getAllUsers()
				.flatMap(user -> Flux
						.zip(Flux.interval(Duration.ofSeconds(2)), Flux.fromStream(Stream.generate(() -> user)))
						.map(Tuple2::getT2));
	} */
}
