package org.romanco.library.librarycore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationUserDto {

    private String login;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthday;
    private String sex;
    private String password;
}
