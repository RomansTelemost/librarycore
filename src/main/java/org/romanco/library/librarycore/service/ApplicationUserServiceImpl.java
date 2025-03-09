package org.romanco.library.librarycore.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.dto.ApplicationUserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService, UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void registerUser(ApplicationUserDto applicationUserDto) {
        applicationUserDto.setPassword(bCryptPasswordEncoder.encode(applicationUserDto.getPassword()));
//        mapper todo

    }
}
