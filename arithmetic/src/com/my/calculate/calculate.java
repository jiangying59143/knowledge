package com.my.calculate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class calculate {

    static SimpleDateFormat sf  =new SimpleDateFormat("yyyy-MM-dd");

    public static Date incDate(Date date, int days, boolean includeHoliday){
        int i=0;
        int sum=0;
        int holidays = 0;
        while(true){
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, i);
            if(includeHoliday || !includeHoliday && !(isHolidayIn2019(calendar))){
                sum++;
            }else{
                holidays ++;
            }
            if(sum == days){
                System.out.println("总天数：" + (i+1));
                System.out.println("假期天数："+holidays);
                return calendar.getTime();
            }
            i++;
        }
    }

    public static boolean isHolidayIn2019(Calendar calendar){
        List<String> workdaysOnWeekend = Arrays.asList(new String[]{"2019-02-02","2019-02-03","2019-04-28","2019-05-05","2019-09-29","2019-10-12"});
        List<String> holidays = Arrays.asList(new String[]{"2019-01-01",
                "2019-02-04","2019-02-05","2019-02-06","2019-02-07","2019-02-08","2019-02-09","2019-02-10",
                "2019-04-05","2019-04-06","2019-04-07",
                "2019-05-01","2019-05-02","2019-05-03","2019-05-04",
                "2019-06-07","2019-06-08","2019-06-09",
                "2019-09-13","2019-09-14","2019-09-15",
                "2019-10-01","2019-10-02","2019-10-03","2019-10-04","2019-10-05","2019-10-06","2019-10-07"});
        if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) && !workdaysOnWeekend.contains(sf.format(calendar.getTime()))
        || holidays.contains(sf.format(calendar.getTime()))){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ParseException {
        Date date = sf.parse("2019-01-10");
        System.out.println("开始时间：" + date);
        System.out.println("结束时间：" + incDate(date,128, false));
    }
}
