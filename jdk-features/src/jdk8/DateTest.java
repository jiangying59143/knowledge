package jdk8;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static Date incDateByMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        System.out.println(incDateByMonths(new Date(), 12));
    }
}
