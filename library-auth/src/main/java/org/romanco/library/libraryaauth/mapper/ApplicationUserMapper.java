package org.romanco.library.libraryaauth.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.common.entity.ApplicationUser;
import org.romanco.library.common.entity.ApplicationUserAccount;
import org.romanco.library.libraryaauth.dto.ApplicationUserAccountDTO;
import org.romanco.library.libraryaauth.dto.ApplicationUserDto;

@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {
    ApplicationUserDto toDto(ApplicationUser applicationUser);

//    @Mapping(expression = "java()", target = "sex")
    ApplicationUserAccount toApplicationUserAccount(ApplicationUserAccountDTO applicationUserAccountDTO);
    
    ApplicationUser toApplicationUser(ApplicationUserAccount applicationUserAccount);
    //TODO use java exp instead of value
}
