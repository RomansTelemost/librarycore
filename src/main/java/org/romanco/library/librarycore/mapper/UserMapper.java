package org.romanco.library.librarycore.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.librarycore.dto.ApplicationUserDto;
import org.romanco.library.librarycore.entity.ApplicationUser;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ApplicationUserDto toDto(ApplicationUser applicationUser);

    ApplicationUser toUser(ApplicationUserDto applicationUserDto);
    //TODO use java exp instead of value
}
