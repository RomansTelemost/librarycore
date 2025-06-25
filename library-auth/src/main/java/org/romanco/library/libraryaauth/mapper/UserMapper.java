package org.romanco.library.libraryaauth.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.libraryaauth.dto.ApplicationUserDto;
import org.romanco.library.libraryaauth.entity.ApplicationUser;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ApplicationUserDto toDto(ApplicationUser applicationUser);

//    @Mapping(expression = "java()", target = "sex")
    ApplicationUser toUser(ApplicationUserDto applicationUserDto);
    //TODO use java exp instead of value
}
