package org.romanco.library.librarycore.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.romanco.library.librarycore.entity.enumeration.Sex;

@Converter
public class SexConverter implements AttributeConverter<Sex, String> {

    @Override
    public String convertToDatabaseColumn(Sex sex) {
        return sex == null ? null :sex.getDatabaseValue();
    }

    @Override
    public Sex convertToEntityAttribute(String databaseValue) {
        return databaseValue == null ? null : Sex.fromDataBaseValue(databaseValue);
    }
}
