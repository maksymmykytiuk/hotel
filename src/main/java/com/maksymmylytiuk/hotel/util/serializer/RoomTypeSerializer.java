package com.maksymmylytiuk.hotel.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.maksymmylytiuk.hotel.model.Guest;
import com.maksymmylytiuk.hotel.model.RoomType;

import java.io.IOException;

public class RoomTypeSerializer extends StdSerializer<RoomType> {

    public RoomTypeSerializer() {
        this(null);
    }

    public RoomTypeSerializer(Class<RoomType> t) {
        super(t);
    }

    @Override
    public void serialize(RoomType roomType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("room_type_id", roomType.getId());
        jsonGenerator.writeStringField("name", roomType.getName());
        jsonGenerator.writeEndObject();
    }

}
