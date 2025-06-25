package org.romanco.library.common.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.romanco.library.common.entity.enumeration.Sex;

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
