package org.romanco.library.libraryaauth.service.coreexchange;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(havingValue = "async", name = "core.exchangeMode")
public class CoreServiceExchangeAsync implements CoreServiceExchange {


    private final KafkaTemplate<String, ApplicationUserComposeDto> kafkaTemplate;

    @Override
    public void sendToCore(ApplicationUserComposeDto applicationUserComposeDto) {
        kafkaTemplate.send("registration", applicationUserComposeDto);
    }
}
