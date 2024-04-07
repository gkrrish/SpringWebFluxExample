/*package com.reactwebflux.client;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.reactwebflux.entity.EmployeeUser;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Component
public class WebClientUtil {

	private final WebClient webClient = null;

	public WebClient.ResponseSpec getFakeUsers() {
		return webClient.get().uri("https://randomuser.me/api/").retrieve();
	}

	public Mono<EmployeeUser> postUser(EmployeeUser user) {
		return webClient.post().uri("http://localhost:9000/api/users").header("Authorization", "Basic MY_PASSWORD")
				.accept(MediaType.APPLICATION_JSON).body(Mono.just(user), EmployeeUser.class).retrieve()
				.bodyToMono(EmployeeUser.class).log().retryWhen(Retry.backoff(10, Duration.ofSeconds(2)))
				.onErrorReturn(new EmployeeUser())
//				.doOnError(throwable -> log.error("Result error out for POST user", throwable))
//				.doFinally(signalType -> log.info("Result Completed for POST User: {}", signalType))
				;
	}

}
*/