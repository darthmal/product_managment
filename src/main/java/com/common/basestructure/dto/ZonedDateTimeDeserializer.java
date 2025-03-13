package com.common.basestructure.dto;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
    private static final DateTimeFormatter formatter;

    public ZonedDateTimeDeserializer() {
    }

    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String date = jsonParser.getText();
        return ZonedDateTime.parse(date, formatter);
    }

    static {
        formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    }
}
