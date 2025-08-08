package org.romanco.library.librarycore.config;

import org.romanco.library.librarycore.filter.ApiKeyFilter;
import org.romanco.library.librarycore.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String secret;

    //TODO Переделать на map. Развернуть ключ и значение
    @Value("${apiKeys.authServiceApiKey}")
    private String authServiceApiKey;

//    @Value("${apiKeys}")
//    private Map<String, String> apiKeys;
//
//    public void setApiKeys(Map<String, String> apiKeys) {
//        this.apiKeys = apiKeys;
//    }
//
//    public Map<String, String> getApiKeys() {
//        return apiKeys;
//    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().authenticated())
                .addFilterBefore(new JwtFilter(secret), BasicAuthenticationFilter.class)
                .addFilterAfter(new ApiKeyFilter(authServiceApiKey), BasicAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
