package com.maksymmylytiuk.hotel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/checkOut")
public class CheckOutController {

    @Autowired
    ReceptionService receptionService;

    @Autowired
    ObjectMapper objectMapper;

    @PutMapping(value = "/")
    public @ResponseBody
    ResponseEntity putCheckOut(@RequestBody String json) {
        try {
            Reception reception = objectMapper.readValue(json, Reception.class);
            Reception newReception = receptionService.getById(reception.getId());
            newReception.setTo(reception.getTo());
            receptionService.save(newReception);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
