package org.romanco.library.libraryaauth.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.romanco.library.libraryaauth.entity.ApplicationUserAccount;
import org.romanco.library.libraryaauth.mapper.ApplicationUserAccountMapper;
import org.romanco.library.libraryaauth.repository.ApplicationUserAccountRepository;
import org.romanco.library.libraryaauth.service.coreexchange.CoreServiceExchange;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ApplicationUserAccountMapper applicationUserAccountMapper;

    private final ApplicationUserAccountRepository applicationUserAccountRepository;

    private final CoreServiceExchange coreServiceExchange;

    @Override
    @Transactional
    public void registerUser(ApplicationUserComposeDto applicationUserComposeDto) {
        applicationUserComposeDto.setPassword(bCryptPasswordEncoder.encode(applicationUserComposeDto.getPassword()));
        ApplicationUserAccount applicationUserAccount = applicationUserAccountMapper.toApplicationUserAccount(applicationUserComposeDto);
        applicationUserAccountRepository.save(applicationUserAccount);

        applicationUserComposeDto.setPassword(null);
        coreServiceExchange.sendToCore(applicationUserComposeDto);
    }
}
