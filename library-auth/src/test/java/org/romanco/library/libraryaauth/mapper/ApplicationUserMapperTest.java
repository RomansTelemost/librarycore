package org.romanco.library.libraryaauth.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.romanco.library.common.entity.ApplicationUser;
import org.romanco.library.common.entity.ApplicationUserAccount;
import org.romanco.library.libraryaauth.dto.ApplicationUserComposeDto;

import java.time.LocalDate;
import java.time.Month;

class ApplicationUserMapperTest {

    private final ApplicationUserMapper applicationUserMapper = Mappers.getMapper(ApplicationUserMapper.class);

    private final static ApplicationUserComposeDto DTO = ApplicationUserComposeDto.builder()
            .login("login")
            .firstName("firstName")
            .lastName("lastName")
            .birthday(LocalDate.of(1990, Month.JANUARY, 10))
            .sex("MALE")
            .password("123")
            .build();

    @Test
    void toApplicationUserAccount() {
        ApplicationUserAccount entity = applicationUserMapper.toApplicationUserAccount(DTO);
        Assertions.assertEquals(DTO.getLogin(), entity.getLogin());
        Assertions.assertEquals(DTO.getPassword(), entity.getPassword());
    }

    @Test
    void toApplicationUser() {
        ApplicationUser entity = applicationUserMapper.toApplicationUser(DTO);
        Assertions.assertEquals(DTO.getFirstName(), entity.getFirstName());
        Assertions.assertEquals(DTO.getLastName(), entity.getLastName());
        Assertions.assertEquals(DTO.getBirthday(), entity.getBirthday());
        Assertions.assertEquals(DTO.getSex(), entity.getSex().name());
    }
}