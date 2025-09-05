package org.romanco.library.librarycore.service.kafka;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.romanco.library.librarycore.entity.ApplicationUser;
import org.romanco.library.librarycore.mapper.ApplicationUserMapper;
import org.romanco.library.librarycore.service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(havingValue = "true", name = "kafka.registrationEventsListenerEnabled")
public class ConsumerServiceImpl implements ConsumerService {

    private final UserService userService;

    private final ApplicationUserMapper applicationUserMapper;

    @KafkaListener(topics = {"registration"})
    @Override
    public void consumeMessage(@Payload ApplicationUserComposeDto applicationUserComposeDto, Acknowledgment ack) {
        ApplicationUser applicationUser = applicationUserMapper.toApplicationUser(applicationUserComposeDto);
        userService.save(applicationUser);
        ack.acknowledge();
    }
}
