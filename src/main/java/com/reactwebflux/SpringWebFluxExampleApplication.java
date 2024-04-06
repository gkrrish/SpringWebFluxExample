package com.reactwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
