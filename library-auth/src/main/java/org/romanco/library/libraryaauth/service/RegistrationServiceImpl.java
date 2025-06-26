package org.romanco.library.libraryaauth.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.repository.UserRepository;
import org.romanco.library.libraryaauth.dto.ApplicationUserDto;
import org.romanco.library.libraryaauth.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void registerUser(ApplicationUserDto applicationUserDto) {
        applicationUserDto.setPassword(bCryptPasswordEncoder.encode(applicationUserDto.getPassword()));
        userRepository.save(userMapper.toUser(applicationUserDto));
        userRepository.save();
    }
}
