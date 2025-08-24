package org.romanco.library.librarycore.service;

public interface UserActionService {

    void takeBook(Long bookId, Long applicationUserId);
}
