package com.reactwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableR2dbcAuditing
@EnableWebFlux
//@EnableR2dbcRepositories
@ComponentScan(basePackages = {"com.reactwebflux", "com.reactwebflux.repository"})
@EnableR2dbcRepositories(considerNestedRepositories = true)//this I kept for auto-refresh of the database, still it is not working.
@SpringBootApplication
public class SpringWebFluxExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxExampleApplication.class, args);
		System.out.println("http://localhost:9090");
		String listOfEndPoints ="http://localhost:8287/actuator/prometheus"+
								"http://localhost:8287/actuator/health"+
								"http://localhost:8287/actuator"+
								"http://localhost:9090/metrics"+
								"use this for Grafana integration : http://172.17.0.4:9090";
		
		System.out.println(listOfEndPoints);
		
	}

}
