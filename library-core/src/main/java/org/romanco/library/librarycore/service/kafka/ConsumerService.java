package org.romanco.library.librarycore.service.kafka;

import org.romanco.library.common.dto.ApplicationUserComposeDto;

public interface ConsumerService {
    void consumeMessage(ApplicationUserComposeDto applicationUserComposeDto);
}
