package org.romanco.library.libraryaauth.service;

import org.romanco.library.libraryaauth.dto.ApplicationUserAccountDTO;

public interface RegistrationService {

    void registerUser(ApplicationUserAccountDTO applicationUserAccountDTO);
}
