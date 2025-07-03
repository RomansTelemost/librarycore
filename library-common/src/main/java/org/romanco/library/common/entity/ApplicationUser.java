package org.romanco.library.common.entity;


import jakarta.persistence.*;
import lombok.*;
import org.romanco.library.common.entity.converter.SexConverter;
import org.romanco.library.common.entity.enumeration.Sex;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "application_user")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "sex")
    @Convert(converter = SexConverter.class)
    private Sex sex;
}

