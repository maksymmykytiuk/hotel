package com.maksymmylytiuk.hotel.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.maksymmylytiuk.hotel.model.Guest;

import java.io.IOException;

public class GuestSerializer  extends StdSerializer<Guest> {

    public GuestSerializer() {
        this(null);
    }

    public GuestSerializer(Class<Guest> t) {
        super(t);
    }

    @Override
    public void serialize(Guest guest, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", guest.getId());
        jsonGenerator.writeStringField("firstName", guest.getFirstName());
        jsonGenerator.writeStringField("middleName", guest.getMiddleName());
        jsonGenerator.writeStringField("secondName", guest.getSecondName());
        jsonGenerator.writeStringField("address", guest.getAddress());
        jsonGenerator.writeStringField("phone", guest.getPhone());

        jsonGenerator.writeFieldName("country");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", guest.getCountry().getId());
        jsonGenerator.writeStringField("name", guest.getCountry().getName());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }

}
