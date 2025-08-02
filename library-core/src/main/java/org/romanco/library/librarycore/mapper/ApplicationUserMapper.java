package org.romanco.library.librarycore.mapper;

import org.mapstruct.Mapper;
import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.romanco.library.librarycore.entity.ApplicationUser;

@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {

    ApplicationUser toApplicationUser(ApplicationUserComposeDto applicationUserComposeDto);
    //TODO use java exp instead of value
}
