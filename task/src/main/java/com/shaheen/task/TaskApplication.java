package com.shaheen.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		String javaVersion = System.getProperty("java.version");
		System.out.println("Java Version: " + javaVersion);

		SpringApplication.run(TaskApplication.class, args);
	}

}
