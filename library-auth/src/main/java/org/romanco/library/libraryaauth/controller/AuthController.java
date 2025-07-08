package org.romanco.library.libraryaauth.controller;

import lombok.RequiredArgsConstructor;
import org.romanco.library.libraryaauth.dto.AuthDto;
import org.romanco.library.libraryaauth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/v1/auth")
    public String auth(@RequestBody AuthDto authDto) {
        return authService.authenticate(authDto);
    }
}
