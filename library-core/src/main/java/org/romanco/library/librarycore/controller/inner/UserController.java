package org.romanco.library.librarycore.controller.inner;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/v1/inner/user")
    public void saveApplicationUser() {

    }

}
