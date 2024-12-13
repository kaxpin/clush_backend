package com.expample.clush_backend.controller;

import com.expample.clush_backend.auth.AuthService;
import com.expample.clush_backend.dto.CalendarDTO;
import com.expample.clush_backend.dto.ClushResponse;
import com.expample.clush_backend.model.Calendar;
import com.expample.clush_backend.model.Group;
import com.expample.clush_backend.model.User;
import com.expample.clush_backend.service.CalendarService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalendarController {

    private CalendarService calendarService;

    public CalendarController(CalendarService calendarService){
        this.calendarService = calendarService;
    }

    @GetMapping("/calendar/select")
    public ResponseEntity<?> selectCalendarInfo(@RequestParam String type
            , @RequestParam String year, @RequestParam String month, @RequestParam String userId
    ) {
            List<Calendar> calendar = new ArrayList<>();
        try {
            if(type.equals("month")){
                calendar = calendarService.findByMonth(userId, year, month);
            } else {
                calendar = calendarService.findByYear(userId, year);
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, calendar,"조회 성공"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500, calendar, e.getMessage()));
        }
    }

//    @GetMapping("/calendar/year/{data}/{userId}")
//    public ResponseEntity<?> getCalendarByYear(@PathVariable String date, @PathVariable String userId) {
//
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ClushResponse(200, date,"회원 가입 성공"));
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                    new ClushResponse(500, date, e.getMessage()));
//        }
//    }

    @PostMapping("/calendar/create")
    public ResponseEntity<?> createCalendar(@RequestBody CalendarDTO calendarDto) {

            Calendar calendar = new Calendar();
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            calendar = objectMapper.convertValue(calendarDto, Calendar.class);

            User user = new User();
            user.setUserId(calendarDto.getWriterId());

            Group group = new Group();
            group.setGroupId(calendarDto.getGroupId());

            calendar.setWriter(user);
            calendar.setGroup(null);

            calendarService.createCalendar(calendar);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, calendar, "일정 생성 성공"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500, calendar, e.getMessage()));
        }
    }

    //수정
    @PostMapping("/calendar/update")
    public ResponseEntity<?> uodateCalendarByMonth(@RequestBody User user) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200,user.getUserId(),"회원 가입 성공"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500,user.getUserId(), e.getMessage()));
        }
    }

    //삭제
    @PostMapping("/calendar/delete/{scheduleId}/{userId}")
    //예 일단 보류
    public ResponseEntity<?> deleteCalendar(@RequestBody User user) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200,user.getUserId(),"회원 가입 성공"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500,user.getUserId(), e.getMessage()));
        }
    }



}
