package org.romanco.library.libraryaauth.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.common.entity.ApplicationUser;
import org.romanco.library.common.entity.ApplicationUserAccount;
import org.romanco.library.libraryaauth.dto.ApplicationUserComposeDto;

@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {

//    @Mapping(expression = "java()", target = "sex")
    ApplicationUserAccount toApplicationUserAccount(ApplicationUserComposeDto applicationUserComposeDto);
    
    ApplicationUser toApplicationUser(ApplicationUserComposeDto applicationUserComposeDto);
    //TODO use java exp instead of value
}
