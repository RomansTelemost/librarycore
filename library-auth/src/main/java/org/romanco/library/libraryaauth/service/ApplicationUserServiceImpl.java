package org.romanco.library.libraryaauth.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.libraryaauth.dto.ApplicationUserDto;
import org.romanco.library.libraryaauth.mapper.UserMapper;
import org.romanco.library.libraryaauth.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService, UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User with login: %s not registered".formatted(username)));
    }

    @Override
    public void registerUser(ApplicationUserDto applicationUserDto) {
        applicationUserDto.setPassword(bCryptPasswordEncoder.encode(applicationUserDto.getPassword()));
        userRepository.save(userMapper.toUser(applicationUserDto));
    }
}
