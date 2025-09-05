package org.romanco.library.librarycore.service;

import org.romanco.library.librarycore.entity.ApplicationUser;

public interface UserService {
    void save(ApplicationUser applicationUser);

    Long resolveUserId(String login);
}
