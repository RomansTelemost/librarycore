package org.romanco.library.libraryaauth.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.romanco.library.libraryaauth.entity.ApplicationUserAccount;

@Mapper(componentModel = "spring")
public interface ApplicationUserAccountMapper {

//    @Mapping(expression = "java()", target = "sex")
    ApplicationUserAccount toApplicationUserAccount(ApplicationUserComposeDto applicationUserComposeDto);
}
