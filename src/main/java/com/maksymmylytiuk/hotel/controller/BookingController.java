package com.maksymmylytiuk.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.service.ReceptionService;
import com.maksymmylytiuk.hotel.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.maksymmylytiuk.hotel.constants.RoomStatusConstant.BOOKED;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    ReceptionService receptionService;

    @Autowired
    RoomStatusService roomStatusService;

    @Autowired
    ObjectMapper objectMapper;

    @PutMapping(value = "/")
    public @ResponseBody
    ResponseEntity putBooking(@RequestBody String json) {
        try {
            Reception reception = objectMapper.readValue(json, Reception.class);
            reception.setRoomStatus(roomStatusService.getById(BOOKED));

            if (roomStatusService.roomIsFreeInPeriod(reception.getRoom().getId(),
                    reception.getFrom(),
                    reception.getTo(),
                    reception.getGuest()))
                receptionService.save(reception);
            else
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public @ResponseBody
    ResponseEntity getBooking() throws JsonProcessingException {
        List<Reception> receptions = receptionService.getAllByStatusId(BOOKED);
        return ResponseEntity.ok(objectMapper.writeValueAsString(receptions));
    }

    @DeleteMapping(value = "/{idBooking}")
    public @ResponseBody
    ResponseEntity deleteBooking(@PathVariable("idBooking") Long idBooking) {
        receptionService.delete(idBooking);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/{idBooking}")
    public @ResponseBody
    ResponseEntity updateBooking(@PathVariable("idBooking") Long idBooking, @RequestBody String json) {
        try {
            Reception reception = objectMapper.readValue(json, Reception.class);

            if (roomStatusService.roomIsFreeInPeriod(reception.getRoom().getId(),
                    reception.getFrom(),
                    reception.getTo(),
                    reception.getGuest()))
                receptionService.update(idBooking, reception);
            else
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
