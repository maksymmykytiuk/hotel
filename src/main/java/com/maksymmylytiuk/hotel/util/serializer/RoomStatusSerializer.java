package com.maksymmylytiuk.hotel.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.maksymmylytiuk.hotel.model.RoomStatus;

import java.io.IOException;

public class RoomStatusSerializer extends StdSerializer<RoomStatus> {

    public RoomStatusSerializer() {
        this(null);
    }

    public RoomStatusSerializer(Class<RoomStatus> t) {
        super(t);
    }

    @Override
    public void serialize(RoomStatus roomStatus, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", roomStatus.getId());
        jsonGenerator.writeStringField("name", roomStatus.getName());
        jsonGenerator.writeEndObject();
    }
}
