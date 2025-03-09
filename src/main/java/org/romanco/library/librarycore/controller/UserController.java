package org.romanco.library.librarycore.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class UserController {

    @PostMapping("/registration")
    public void registerUser() {

    }
}
