package org.romanco.library.libraryaauth.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.repository.ApplicationUserAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ApplicationUserAccountRepository applicationUserAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserAccountRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User with login: %s not registered".formatted(username)));
    }

}
