package org.romanco.library.libraryaauth.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.entity.ApplicationUser;
import org.romanco.library.common.entity.ApplicationUserAccount;
import org.romanco.library.common.repository.ApplicationUserAccountRepository;
import org.romanco.library.common.repository.ApplicationUserRepository;
import org.romanco.library.libraryaauth.dto.ApplicationUserAccountDTO;
import org.romanco.library.libraryaauth.mapper.ApplicationUserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ApplicationUserMapper applicationUserMapper;

    private final ApplicationUserAccountRepository applicationUserAccountRepository;

    private final ApplicationUserRepository applicationUserRepository;

    @Override
    @Transactional
    public void registerUser(ApplicationUserAccountDTO applicationUserAccountDTO) {
        applicationUserAccountDTO.setPassword(bCryptPasswordEncoder.encode(applicationUserAccountDTO.getPassword()));
        ApplicationUserAccount applicationUserAccount = applicationUserMapper.toApplicationUserAccount(applicationUserAccountDTO);
        applicationUserAccount.setApplicationUser(new ApplicationUser());
        applicationUserAccountRepository.save(applicationUserAccount);
//        applicationUserRepository.save(applicationUserMapper.toApplicationUser(applicationUserAccount));
    }
}
