package com.maksymmylytiuk.hotel.util.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class RoomDeserializer extends StdDeserializer<Room> {

    @Autowired
    RoomService roomService;

    public RoomDeserializer() {
        this(null);
    }

    public RoomDeserializer(Class<Room> t) {
        super(t);
    }

    @Override
    public Room deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return roomService.getById(jsonParser.getLongValue());
    }
}
