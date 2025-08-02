package org.romanco.library.libraryaauth.repository;

import org.romanco.library.libraryaauth.entity.ApplicationUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserAccountRepository extends JpaRepository<ApplicationUserAccount, Long> {

    Optional<ApplicationUserAccount> findByLogin(String login);

}
