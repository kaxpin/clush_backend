package com.expample.clush_backend.repository;

import com.expample.clush_backend.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {

    @Query("SELECT c FROM Calendar c WHERE c.writer.userId = :userId " +
            "AND ( " +
            "(FUNCTION('YEAR', c.startDate) = :year AND FUNCTION('MONTH', c.startDate) = :month) OR " +
            "(FUNCTION('YEAR', c.endDate) = :year AND FUNCTION('MONTH', c.endDate) = :month) OR " +
            "(c.startDate <= :endOfMonth AND c.endDate >= :startOfMonth))")
    List<Calendar> findByMonth(String userId, int year, int month, Timestamp startOfMonth, Timestamp endOfMonth);

    @Query("SELECT c FROM Calendar c WHERE c.writer.userId = :userId " +
            "AND ( " +
            "(FUNCTION('YEAR', c.startDate) = :year) OR " +
            "(FUNCTION('YEAR', c.endDate) = :year) OR " +
            "(c.startDate <= :endOfYear AND c.endDate >= :startOfYear))")
    List<Calendar> findByYear(String userId, int year, Timestamp startOfMonth, Timestamp endOfMonth);
}
