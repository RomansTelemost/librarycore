package org.romanco.library.libraryaauth.controller;

import lombok.RequiredArgsConstructor;
import org.romanco.library.libraryaauth.dto.ApplicationUserDto;
import org.romanco.library.libraryaauth.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/api/v1/register")
    public void registerUser(@RequestBody ApplicationUserDto applicationUserDto) {
        registrationService.registerUser(applicationUserDto);
    }
}
