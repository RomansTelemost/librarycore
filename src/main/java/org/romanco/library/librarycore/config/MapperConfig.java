package org.romanco.library.librarycore.config;

import org.mapstruct.factory.Mappers;
import org.romanco.library.librarycore.mapper.AuthorMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public AuthorMapper authorMapper() {
        return Mappers.getMapper(AuthorMapper.class);
    }
}
