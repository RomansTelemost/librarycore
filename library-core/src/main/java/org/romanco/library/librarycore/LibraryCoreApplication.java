package org.romanco.library.librarycore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.romanco.library.librarycore.repository", "org.romanco.library.common.repository"})
@EntityScan(basePackages = {"org.romanco.library.common.entity", "org.romanco.library.librarycore.entity"})
public class LibraryCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryCoreApplication.class, args);
	}

}
