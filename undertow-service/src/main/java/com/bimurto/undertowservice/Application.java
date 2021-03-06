package com.bimurto.undertowservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Slf4j
@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@GetMapping(value = "/blocking")
	public void blockingCall() throws InterruptedException {
		String uuid = UUID.randomUUID().toString();
		log.info("{} started.", uuid);
		Thread.sleep(10000);
		log.info("{} ended.", uuid);
	}

}
