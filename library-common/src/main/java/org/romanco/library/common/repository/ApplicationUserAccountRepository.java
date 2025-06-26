package org.romanco.library.common.repository;

import org.romanco.library.common.entity.ApplicationUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserAccountRepository extends JpaRepository<ApplicationUserAccount, String> {
}
