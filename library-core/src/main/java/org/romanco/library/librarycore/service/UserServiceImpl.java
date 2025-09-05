package org.romanco.library.librarycore.service;

import lombok.RequiredArgsConstructor;
import org.romanco.library.librarycore.entity.ApplicationUser;
import org.romanco.library.librarycore.repository.ApplicationUserRepository;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ApplicationUserRepository applicationUserRepository;

    private final Jedis jedis;

    @Override
    public void save(ApplicationUser applicationUser) {
        applicationUserRepository.save(applicationUser);
    }

    @Override
    public Long resolveUserId(String login) {
        //todo ttl is important
        String cacheUserId = jedis.hget("testLogins", login);
        if (cacheUserId == null) {
            Long userId = applicationUserRepository.findIdByLogin(login)
                    .orElseThrow(() -> new IllegalStateException("User with login %s not found".formatted(login)));
            jedis.hset("testLogins", login, userId.toString());
            return userId;
        }
        return Long.valueOf(cacheUserId);
    }
}
