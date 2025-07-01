package org.romanco.library.common.repository;

import org.romanco.library.common.entity.ApplicationUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserAccountRepository extends JpaRepository<ApplicationUserAccount, Long> {

    Optional<ApplicationUserAccount> findByLogin(String login);

}
