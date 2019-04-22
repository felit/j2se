package com.livedrof.j2se.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {
    @Test
    public void testFormat() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date.format(fmt);
        System.out.println("" + date.format(fmt));
        LocalDate lastMonth = date.minusMonths(1l);
        System.out.println("" + lastMonth.format(fmt));
    }

    @Test
    public void testLocalDateFormat() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:dd");
        System.out.println(localDateTime.format(fmt));
        LocalDateTime lastMonth = localDateTime.minusMonths(1l);
        System.out.println(lastMonth.format(fmt));
    }
}
