package org.romanco.library.libraryaauth.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.romanco.library.common.entity.ApplicationUser;
import org.romanco.library.common.entity.ApplicationUserAccount;
import org.romanco.library.common.entity.enumeration.Sex;
import org.romanco.library.common.repository.ApplicationUserAccountRepository;
import org.romanco.library.libraryaauth.dto.ApplicationUserComposeDto;
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
class RegistrationServiceImplTest {

    private final RegistrationService registrationService;

    private final ApplicationUserAccountRepository applicationUserAccountRepository;

    private final static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private final static ApplicationUserComposeDto DTO = ApplicationUserComposeDto.builder()
            .login("login")
            .firstName("firstName")
            .lastName("lastName")
            .birthday(LocalDate.of(1990, Month.JANUARY, 10))
            .sex("MALE")
            .password("123")
            .build();

    private static ApplicationUserAccount expectedUserAccount;

    private static ApplicationUser expectedApplicationUser;

    @Autowired
    public RegistrationServiceImplTest(RegistrationService registrationService,
                                       ApplicationUserAccountRepository applicationUserAccountRepository) {
        this.registrationService = registrationService;
        this.applicationUserAccountRepository = applicationUserAccountRepository;
    }

    @BeforeAll
    static void prepareExpectedData() {
        expectedUserAccount = new ApplicationUserAccount();
        expectedUserAccount.setLogin("login");
        expectedUserAccount.setPassword(bCryptPasswordEncoder.encode("123"));
        expectedApplicationUser = new ApplicationUser();
        expectedApplicationUser.setFirstName("firstName");
        expectedApplicationUser.setLastName("lastName");
        expectedApplicationUser.setBirthday(LocalDate.of(1990, Month.JANUARY, 10));
        expectedApplicationUser.setSex(Sex.MALE);
        expectedUserAccount.setApplicationUser(expectedApplicationUser);
    }

    @Test
    void registerUser() {
//        ApplicationUserAccount expectedUserAccount = new ApplicationUserAccount();
//        expectedUserAccount.setLogin("login");
//        expectedUserAccount.setPassword(bCryptPasswordEncoder.encode("123"));
//        ApplicationUser expectedApplicationUser = new ApplicationUser();
//        expectedApplicationUser.setFirstName("firstName");
//        expectedApplicationUser.setLastName("lastName");
//        expectedApplicationUser.setBirthday(LocalDate.of(1990, Month.JANUARY, 10));
//        expectedApplicationUser.setSex(Sex.MALE);
//        expectedUserAccount.setApplicationUser(expectedApplicationUser);

        registrationService.registerUser(DTO);

        Optional<ApplicationUserAccount> actualOpt = applicationUserAccountRepository.findByLogin(expectedUserAccount.getLogin());
        assertTrue(actualOpt.isPresent());

        ApplicationUserAccount actualUserAccount = actualOpt.get();
        ApplicationUser actualApplicationUser = actualUserAccount.getApplicationUser();

        assertEquals(expectedApplicationUser.getFirstName(), actualApplicationUser.getFirstName());
        assertEquals(expectedApplicationUser.getLastName(), actualApplicationUser.getLastName());
        assertEquals(expectedApplicationUser.getBirthday(), actualApplicationUser.getBirthday());
        assertEquals(expectedApplicationUser.getSex(), actualApplicationUser.getSex());

        assertEquals(expectedUserAccount.getLogin(), actualUserAccount.getLogin());
    }
}