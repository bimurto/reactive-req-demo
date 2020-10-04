package com.bimurto.reactiveservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	@GetMapping(value = "/non-blocking")
	public Mono<String> blockingCall() throws InterruptedException {
		String uuid = UUID.randomUUID().toString();
		log.info("{} making api call.", uuid);
		WebClient webClient = WebClient.create("http://localhost:8080/blocking");

		return webClient.get().exchange().flatMap(res -> res.bodyToMono(String.class));
	}
}
