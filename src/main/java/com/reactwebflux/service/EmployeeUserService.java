package com.reactwebflux.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reactwebflux.entity.EmployeeUser;
import com.reactwebflux.repository.EmployeeUserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class EmployeeUserService {

	private EmployeeUserRepository employeeUserRepository;

	public EmployeeUserService(EmployeeUserRepository employeeUserRepository) {
		this.employeeUserRepository = employeeUserRepository;
	}

	public Mono<EmployeeUser> createEmployeeUser(EmployeeUser user) {
		return employeeUserRepository.save(user);
	}

	public Flux<EmployeeUser> getAllUsers() {
		return employeeUserRepository.findAll();
	}

	public Mono<EmployeeUser> findById(int userId) {
		return employeeUserRepository.findById(userId);
	}

	public Mono<EmployeeUser> updateUser(int userId, EmployeeUser user) {
		return employeeUserRepository.findById(userId).flatMap(dbUser -> {
			dbUser.setCity(user.getCity());
			dbUser.setMobileNumber(user.getMobileNumber());
			return employeeUserRepository.save(dbUser);
		});
	}

	public Mono<EmployeeUser> deleteUser(int userId) {
		return employeeUserRepository.findById(userId)
				.flatMap(existingUser -> employeeUserRepository.delete(existingUser).then(Mono.just(existingUser)));
	}

	public Flux<EmployeeUser> fetchUsers(String name) {
		return employeeUserRepository.findByNameLike(name);
	}
}
