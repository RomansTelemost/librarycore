package org.romanco.library.librarycore.controller;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.dto.ApplicationUserDto;
import org.romanco.library.librarycore.service.ApplicationUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final ApplicationUserService applicationUserService;

    @PostMapping("/api/v1/register")
    public void registerUser(@RequestBody ApplicationUserDto applicationUserDto) {
        applicationUserService.registerUser(applicationUserDto);
    }
}
