package org.romanco.library.librarycore.controller;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.Book;
import org.romanco.library.librarycore.service.UserActionService;
import org.romanco.library.librarycore.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserActionController {

    private final UserActionService actionService;

    private final UserService userService;

    @PostMapping("/book/{id}")
    public void takeBook(@PathVariable Long id) {

        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        actionService.takeBook(id, );
    }

    public void takeOffBook(Book book) {

    }


}
