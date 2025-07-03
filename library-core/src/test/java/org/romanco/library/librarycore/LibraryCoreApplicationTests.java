package org.romanco.library.librarycore;

import org.junit.jupiter.api.Test;
import org.romanco.library.common.entity.ApplicationUser;
import org.romanco.library.common.entity.ApplicationUserAccount;
import org.romanco.library.common.repository.ApplicationUserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Testcontainers
@ActiveProfiles({"test"})
class LibraryCoreApplicationTests {

	private final ApplicationUserAccountRepository applicationUserAccountRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public LibraryCoreApplicationTests(ApplicationUserAccountRepository applicationUserAccountRepository,
									   BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.applicationUserAccountRepository = applicationUserAccountRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Test
	public void createAndFindById() {
		ApplicationUserAccount expected = new ApplicationUserAccount();
		expected.setLogin("login");
		expected.setPassword(bCryptPasswordEncoder.encode("123"));

		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setFirstName("setFirstName");
		applicationUser.setLastName("setLastName");
		applicationUser.setBirthday(LocalDate.of(2025, Month.JULY, 1));
		expected.setApplicationUser(applicationUser);
		applicationUserAccountRepository.save(expected);

		Optional<ApplicationUserAccount> actualOpt = applicationUserAccountRepository.findByLogin(expected.getLogin());
		assertTrue(actualOpt.isPresent());
		ApplicationUserAccount actual = actualOpt.get();

		assertEquals(expected.getApplicationUser(), actual.getApplicationUser());
		assertEquals(expected.getLogin(), actual.getLogin());

		//todo создание через сервис
		//поиск через repository
	}

}
