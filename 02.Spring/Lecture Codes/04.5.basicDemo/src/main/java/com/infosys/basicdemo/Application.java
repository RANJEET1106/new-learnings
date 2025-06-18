package com.infosys.basicdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${app.app-name}")
	private String appName;
	@Value("${server.port}")
	private Integer portNo;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App name is: " + appName);
		System.out.println("Server port is: " + portNo);
	}
}
