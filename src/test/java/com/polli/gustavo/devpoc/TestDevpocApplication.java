package com.polli.gustavo.devpoc;

import org.springframework.boot.SpringApplication;

public class TestDevpocApplication {

	public static void main(String[] args) {
		SpringApplication.from(DevpocApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
