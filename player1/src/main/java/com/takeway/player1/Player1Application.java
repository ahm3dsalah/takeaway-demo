package com.takeway.player1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Player1Application {


	public static void main(String[] args) {
		SpringApplication.run(Player1Application.class, args);
	}
}
