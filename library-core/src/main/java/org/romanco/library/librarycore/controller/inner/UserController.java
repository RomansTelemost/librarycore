package org.romanco.library.librarycore.controller.inner;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.romanco.library.librarycore.entity.ApplicationUser;
import org.romanco.library.librarycore.mapper.ApplicationUserMapper;
import org.romanco.library.librarycore.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ApplicationUserMapper applicationUserMapper;

    @PostMapping("/api/v1/inner/user")
    public void saveApplicationUser(@RequestBody ApplicationUserComposeDto applicationUserComposeDto) {
        ApplicationUser applicationUser = applicationUserMapper.toApplicationUser(applicationUserComposeDto);
        userService.save(applicationUser);
    }
}
