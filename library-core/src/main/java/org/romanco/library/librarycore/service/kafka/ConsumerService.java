package org.romanco.library.librarycore.service.kafka;

import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.springframework.kafka.support.Acknowledgment;

public interface ConsumerService {
    void consumeMessage(ApplicationUserComposeDto applicationUserComposeDto, Acknowledgment ack);
}
