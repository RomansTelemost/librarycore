package org.romanco.library.librarycore.repository;

import org.romanco.library.librarycore.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<Long> findIdByLogin(String login);
}
