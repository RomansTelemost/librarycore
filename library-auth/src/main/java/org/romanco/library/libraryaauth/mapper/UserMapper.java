package org.romanco.library.libraryaauth.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.common.entity.ApplicationUser;
import org.romanco.library.libraryaauth.dto.ApplicationUserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ApplicationUserDto toDto(ApplicationUser applicationUser);

//    @Mapping(expression = "java()", target = "sex")
    ApplicationUser toUser(ApplicationUserDto applicationUserDto);
    //TODO use java exp instead of value
}
