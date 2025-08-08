package org.romanco.library.libraryaauth.service.coreexchange;

import lombok.RequiredArgsConstructor;
import org.romanco.library.common.dto.ApplicationUserComposeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CoreServiceExchangeSync implements CoreServiceExchange {

    private final RestTemplate restTemplate;

    @Value("${core.url.userController}")
    private String coreUrl;

    @Value("${apiKeys.customApiKey}")
    private String apiKey;

    @Override
    public void sendToCore(ApplicationUserComposeDto applicationUserComposeDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "api_key=%s".formatted(apiKey));

        HttpEntity<ApplicationUserComposeDto> httpEntity = new HttpEntity<>(applicationUserComposeDto, headers);
        restTemplate.exchange(coreUrl, HttpMethod.POST, httpEntity, Void.class);
    }
}
