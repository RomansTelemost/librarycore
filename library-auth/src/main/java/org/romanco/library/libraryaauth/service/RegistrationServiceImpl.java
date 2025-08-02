package org.romanco.library.libraryaauth.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.romanco.library.libraryaauth.entity.ApplicationUserAccount;
import org.romanco.library.libraryaauth.mapper.ApplicationUserAccountMapper;
import org.romanco.library.libraryaauth.repository.ApplicationUserAccountRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ApplicationUserAccountMapper applicationUserAccountMapper;

    private final ApplicationUserAccountRepository applicationUserAccountRepository;

    private final RestTemplate restTemplate;

    private final static String CORE_URL = "http://localhost:8082/api/v1/inner/user";

    @Override
    @Transactional
    public void registerUser(ApplicationUserComposeDto applicationUserComposeDto) {
        applicationUserComposeDto.setPassword(bCryptPasswordEncoder.encode(applicationUserComposeDto.getPassword()));
        ApplicationUserAccount applicationUserAccount = applicationUserAccountMapper.toApplicationUserAccount(applicationUserComposeDto);
        applicationUserAccountRepository.save(applicationUserAccount);

        applicationUserComposeDto.setPassword(null);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "api_key=testApi");

        HttpEntity<ApplicationUserComposeDto> httpEntity = new HttpEntity<>(applicationUserComposeDto, headers);
        restTemplate.exchange(CORE_URL, HttpMethod.POST, httpEntity, Void.class);
    }
}
