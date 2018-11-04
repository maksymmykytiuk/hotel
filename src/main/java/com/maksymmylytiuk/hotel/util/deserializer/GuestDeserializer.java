package com.maksymmylytiuk.hotel.util.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.maksymmylytiuk.hotel.model.Guest;
import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.service.GuestService;
import com.maksymmylytiuk.hotel.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class GuestDeserializer extends StdDeserializer<Guest> {

    @Autowired
    GuestService guestService;

    public GuestDeserializer() {
        this(null);
    }

    public GuestDeserializer(Class<Guest> t) {
        super(t);
    }

    @Override
    public Guest deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return this.guestService.getById(jsonParser.getLongValue());
    }
}
