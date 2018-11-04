package com.maksymmylytiuk.hotel.util.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.maksymmylytiuk.hotel.model.Guest;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.model.RoomType;
import com.maksymmylytiuk.hotel.service.GuestService;
import com.maksymmylytiuk.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class RoomTypeDeserializer extends StdDeserializer<RoomType> {

    @Autowired
    RoomTypeService roomTypeService;

    public RoomTypeDeserializer() {
        this(null);
    }

    public RoomTypeDeserializer(Class<RoomType> t) {
        super(t);
    }

    @Override
    public RoomType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return this.roomTypeService.getById(jsonParser.getLongValue());
    }
}
