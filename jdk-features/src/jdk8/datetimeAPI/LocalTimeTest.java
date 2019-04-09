package jdk8.datetimeAPI;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class LocalTimeTest {
    public static void main(String[] args) {
        //LocalTime example
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //of
        LocalTime time0 = LocalTime.of(10,43,12);
        System.out.println(time0);

        //minus
        LocalTime time1 = LocalTime.of(10,43,12);
        System.out.println(time1);
        LocalTime time2=time1.minusHours(2);
        LocalTime time3=time2.minusMinutes(34);
        System.out.println(time3);


        //plus
        LocalTime time11 = LocalTime.of(10,43,12);
        System.out.println(time11);
        LocalTime time22=time11.plusHours(4);
        LocalTime time33=time22.plusMinutes(18);
        System.out.println(time33);

        //zoneId ChronoUnit
        ZoneId zone1 = ZoneId.of("Asia/Kolkata");
        ZoneId zone2 = ZoneId.of("Asia/Tokyo");
        LocalTime time111 = LocalTime.now(zone1);
        System.out.println("India Time Zone: "+time111);
        LocalTime time222 = LocalTime.now(zone2);
        System.out.println("Japan Time Zone: "+time222);
        long hours = ChronoUnit.HOURS.between(time111, time222);
        System.out.println("Hours between two Time Zone: "+hours);
        long minutes = ChronoUnit.MINUTES.between(time111, time222);
        System.out.println("Minutes between two time zone: "+minutes);
    }

}
