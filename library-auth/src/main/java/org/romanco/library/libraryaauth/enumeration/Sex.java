package org.romanco.library.libraryaauth.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Sex {

    MALE("male"),
    FEMALE("female");

    private final String databaseValue;

    public static Sex fromDataBaseValue(String databaseValue) {
        return Arrays.stream(Sex.values())
                .filter(val -> databaseValue.equals(val.getDatabaseValue()))
                .findFirst()
                .orElseThrow(() ->
                    new IllegalArgumentException("Cannot create enum Sex from databaseValue: %s".formatted(databaseValue))
                );
    }
}
