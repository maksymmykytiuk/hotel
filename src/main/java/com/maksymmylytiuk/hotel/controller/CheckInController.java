package com.maksymmylytiuk.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maksymmylytiuk.hotel.constants.RoomStatusConstant;
import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import com.maksymmylytiuk.hotel.service.ReceptionService;
import com.maksymmylytiuk.hotel.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.maksymmylytiuk.hotel.constants.RoomStatusConstant.CHECKED_IN;

@Controller
@RequestMapping("/checkIn")
public class CheckInController {

    @Autowired
    ReceptionService receptionService;

    @Autowired
    RoomStatusService roomStatusService;

    @Autowired
    ObjectMapper objectMapper;

    @PutMapping(value = "/")
    public @ResponseBody
    ResponseEntity putCheckIn(@RequestBody String json) {
        try {
            Reception reception = objectMapper.readValue(json, Reception.class);
            reception.setRoomStatus(roomStatusService.getById(CHECKED_IN));

            if (roomStatusService.roomIsFreeInPeriodAndGuest(reception.getRoom().getId(),
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
    ResponseEntity getCheckIn() throws JsonProcessingException {
        List<Reception> receptions = receptionService.getAllByStatusId(CHECKED_IN);
        return ResponseEntity.ok(objectMapper.writeValueAsString(receptions));
    }

    @PutMapping(value = "/{idCheckIn}")
    public @ResponseBody
    ResponseEntity updateCheckIn(@PathVariable("idCheckIn") Long idCheckIn, @RequestBody String json) {
        try {
            Reception reception = objectMapper.readValue(json, Reception.class);

            receptionService.update(idCheckIn, reception);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
