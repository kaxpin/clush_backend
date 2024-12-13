package com.expample.clush_backend.service;

import com.expample.clush_backend.exception.AuthException;
import com.expample.clush_backend.model.Calendar;

import com.expample.clush_backend.repository.CalendarRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarService {

    private CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar createCalendar(Calendar calendar){
        return calendarRepository.save(calendar);
    }

    public List<Calendar> findByMonth(String userId, String year, String month){

        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);

        LocalDate startOfMonth = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
        LocalDate endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth());

        Timestamp startTimestamp = Timestamp.valueOf(startOfMonth.atStartOfDay());
        Timestamp endTimestamp = Timestamp.valueOf(endOfMonth.atTime(23, 59, 59));

        return calendarRepository.findByMonth(userId, yearInt, monthInt, startTimestamp, endTimestamp);
    }

    public List<Calendar> findByYear(String userId, String year){

        int yearInt = Integer.parseInt(year);

        LocalDate startOfYear = LocalDate.of(yearInt, 1, 1);
        LocalDate endOfYear = LocalDate.of(yearInt, 12, 31);

        Timestamp startTimestamp = Timestamp.valueOf(startOfYear.atStartOfDay());
        Timestamp endTimestamp = Timestamp.valueOf(endOfYear.atTime(23, 59, 59));

        return calendarRepository.findByYear(userId, yearInt, startTimestamp, endTimestamp);
    }



}
