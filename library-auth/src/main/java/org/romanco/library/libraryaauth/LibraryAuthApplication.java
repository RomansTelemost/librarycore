package org.romanco.library.libraryaauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.romanco.library.common.repository"})
@EntityScan(basePackages = "org.romanco.library.common.entity")
public class LibraryAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAuthApplication.class, args);
	}

}
