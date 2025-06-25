package org.romanco.library.libraryaauth.service;

import org.romanco.library.libraryaauth.dto.ApplicationUserDto;

public interface RegistrationService {

    void registerUser(ApplicationUserDto applicationUserDto);
}
