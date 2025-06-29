package org.romanco.library.libraryaauth.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.entity.ApplicationUser;
import org.romanco.library.common.entity.ApplicationUserAccount;
import org.romanco.library.common.repository.ApplicationUserAccountRepository;
import org.romanco.library.libraryaauth.dto.ApplicationUserComposeDto;
import org.romanco.library.libraryaauth.mapper.ApplicationUserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ApplicationUserMapper applicationUserMapper;

    private final ApplicationUserAccountRepository applicationUserAccountRepository;

    @Override
    @Transactional
    public void registerUser(ApplicationUserComposeDto applicationUserComposeDto) {
        applicationUserComposeDto.setPassword(bCryptPasswordEncoder.encode(applicationUserComposeDto.getPassword()));
        ApplicationUserAccount applicationUserAccount = applicationUserMapper.toApplicationUserAccount(applicationUserComposeDto);
        ApplicationUser applicationUser = applicationUserMapper.toApplicationUser(applicationUserComposeDto);
        applicationUserAccount.setApplicationUser(applicationUser);
        applicationUserAccountRepository.save(applicationUserAccount);
    }
}
