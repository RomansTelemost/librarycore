package org.romanco.library.librarycore;

import org.springframework.boot.SpringApplication;

public class TestLibrarycoreApplication {

	public static void main(String[] args) {
		SpringApplication.from(LibraryCoreApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
