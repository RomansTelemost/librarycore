package org.romanco.library.libraryaauth.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.libraryaauth.dto.AuthDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String authenticate(AuthDto authDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getLogin(), authDto.getPassword()));
        return jwtService.buildJwt(authDto.getLogin());
    }
}
