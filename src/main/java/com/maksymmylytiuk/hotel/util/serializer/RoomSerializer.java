package com.maksymmylytiuk.hotel.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.maksymmylytiuk.hotel.model.Room;

import java.io.IOException;

public class RoomSerializer extends StdSerializer<Room> {

    public RoomSerializer() {
        this(null);
    }

    public RoomSerializer(Class<Room> t) {
        super(t);
    }

    @Override
    public void serialize(Room room, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", room.getId());
        jsonGenerator.writeNumberField("floor", room.getFloor());
        jsonGenerator.writeNumberField("price_per_night", room.getPrice());
        jsonGenerator.writeFieldName("room_type_id");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", room.getRoomType().getId());
        jsonGenerator.writeStringField("name", room.getRoomType().getName());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }
}
