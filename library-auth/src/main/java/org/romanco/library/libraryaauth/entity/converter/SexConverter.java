package org.romanco.library.libraryaauth.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.romanco.library.libraryaauth.enumeration.Sex;

@Converter
public class SexConverter implements AttributeConverter<Sex, String> {

    @Override
    public String convertToDatabaseColumn(Sex sex) {
        return sex.getDatabaseValue();
    }

    @Override
    public Sex convertToEntityAttribute(String databaseValue) {
        return Sex.fromDataBaseValue(databaseValue);
    }
}
