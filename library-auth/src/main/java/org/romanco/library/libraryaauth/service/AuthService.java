package org.romanco.library.libraryaauth.service;

import org.romanco.library.libraryaauth.dto.AuthDto;

public interface AuthService {

    String authenticate(AuthDto authDto);
}
