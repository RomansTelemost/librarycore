package org.romanco.library.libraryaauth.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ActiveProfiles({"test"})
class RegistrationServiceImplTest {

//    private final RegistrationService registrationService;
//
//    private final ApplicationUserAccountRepository applicationUserAccountRepository;
//
//    private final static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//    private final static ApplicationUserComposeDto DTO = ApplicationUserComposeDto.builder()
//            .login("login")
//            .firstName("firstName")
//            .lastName("lastName")
//            .birthday(LocalDate.of(1990, Month.JANUARY, 10))
//            .sex("MALE")
//            .password("123")
//            .build();
//
//    private static ApplicationUserAccount expectedUserAccount;
//
//    private static ApplicationUser expectedApplicationUser;
//
//    @Autowired
//    public RegistrationServiceImplTest(RegistrationService registrationService,
//                                       ApplicationUserAccountRepository applicationUserAccountRepository) {
//        this.registrationService = registrationService;
//        this.applicationUserAccountRepository = applicationUserAccountRepository;
//    }
//
//    @BeforeAll
//    static void prepareExpectedData() {
//        expectedUserAccount = new ApplicationUserAccount();
//        expectedUserAccount.setLogin("login");
//        expectedUserAccount.setPassword(bCryptPasswordEncoder.encode("123"));
//        expectedApplicationUser = new ApplicationUser();
//        expectedApplicationUser.setFirstName("firstName");
//        expectedApplicationUser.setLastName("lastName");
//        expectedApplicationUser.setBirthday(LocalDate.of(1990, Month.JANUARY, 10));
//        expectedApplicationUser.setSex(Sex.MALE);
//        expectedUserAccount.setApplicationUser(expectedApplicationUser);
//    }
//
//    @Test
//    @Transactional
//    void registerUser() {
//        registrationService.registerUser(DTO);
//
//        Optional<ApplicationUserAccount> actualOpt = applicationUserAccountRepository.findByLogin(expectedUserAccount.getLogin());
//        assertTrue(actualOpt.isPresent());
//
//        ApplicationUserAccount actualUserAccount = actualOpt.get();
//        ApplicationUser actualApplicationUser = actualUserAccount.getApplicationUser();
//
//        assertEquals(expectedApplicationUser.getFirstName(), actualApplicationUser.getFirstName());
//        assertEquals(expectedApplicationUser.getLastName(), actualApplicationUser.getLastName());
//        assertEquals(expectedApplicationUser.getBirthday(), actualApplicationUser.getBirthday());
//        assertEquals(expectedApplicationUser.getSex(), actualApplicationUser.getSex());
//
//        assertEquals(expectedUserAccount.getLogin(), actualUserAccount.getLogin());
//    }
}