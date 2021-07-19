package com.example.demo.domain.model.task;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TaskTypeConverter implements AttributeConverter<TaskType, String> {
    @Override
    public String convertToDatabaseColumn(TaskType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getId();
    }

    @Override
    public TaskType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(TaskType.values())
                .filter(c -> c.getId().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
