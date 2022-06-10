package com.limyel.blog.common.framework;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeToLongSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        long millis = instant.toEpochMilli();
        jsonGenerator.writeNumber(millis);
    }
}
