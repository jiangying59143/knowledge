package jdk8.datetimeAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTest {
    public static void main(String[] args) {
        //localDate example
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        LocalDate tomorrow = yesterday.plusDays(2);
        System.out.println("Today date: "+date);
        System.out.println("Yesterday date: "+yesterday);
        System.out.println("Tommorow date: "+tomorrow);

        //localDate 是否是闰年
        LocalDate date1 = LocalDate.of(2017, 1, 13);
        System.out.println(date1.isLeapYear());
        LocalDate date2 = LocalDate.of(2016, 9, 23);
        System.out.println(date2.isLeapYear());

        //localDate atTime
        LocalDate date3 = LocalDate.of(2017, 1, 13);
        LocalDateTime datetime = date3.atTime(1,50,9);
        System.out.println(datetime);
    }
}
