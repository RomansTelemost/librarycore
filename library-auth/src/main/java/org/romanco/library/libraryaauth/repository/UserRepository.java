package org.romanco.library.libraryaauth.repository;

import org.romanco.library.libraryaauth.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, String> {

}
