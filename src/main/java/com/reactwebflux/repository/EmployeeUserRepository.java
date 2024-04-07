package com.reactwebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import com.reactwebflux.entity.EmployeeUser;

@Repository
public interface EmployeeUserRepository extends ReactiveCrudRepository<EmployeeUser, Integer> {

	/*
	 * @Query("SELECT * FROM employee_user WHERE name LIKE $1 ORDER BY age")
	 * Flux<EmployeeUser> findByNameLike(String name);
	 */

}
