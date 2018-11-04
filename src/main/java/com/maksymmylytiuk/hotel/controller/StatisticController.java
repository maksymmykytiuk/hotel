package com.maksymmylytiuk.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maksymmylytiuk.hotel.constants.RoomStatusConstant;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import com.maksymmylytiuk.hotel.service.ReceptionService;
import com.maksymmylytiuk.hotel.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.maksymmylytiuk.hotel.constants.RoomStatusConstant.FREE;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    ReceptionService receptionService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RoomStatusService roomStatusService;

    @RequestMapping(path = "/getRooms", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity getStatisticByRoom(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo,
                                      @RequestParam("type") String type) throws JsonProcessingException, ParseException {
        Date from = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(dateFrom);
        Date to = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(dateTo);
        RoomStatus roomStatus = roomStatusService.getById(RoomStatusConstant.getByName(type));

        if (roomStatus.getId().equals(FREE))
            return ResponseEntity.ok(objectMapper.writeValueAsString(receptionService.getAllFreeRoomInPeriod(from, to)));
        else
            return ResponseEntity.ok(objectMapper.writeValueAsString(receptionService.getAllByStatusAndPeriod(roomStatus, from, to)));
    }
}
