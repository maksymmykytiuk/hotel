package com.maksymmylytiuk.hotel.util.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import com.maksymmylytiuk.hotel.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class RoomStatusDeserializer extends StdDeserializer<RoomStatus> {

    @Autowired
    RoomStatusService roomStatusService;

    public RoomStatusDeserializer() {
        this(null);
    }

    public RoomStatusDeserializer(Class<RoomStatus> t) {
        super(t);
    }

    @Override
    public RoomStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return roomStatusService.getById(jsonParser.getLongValue());
    }
}
