package com.lordjoe.utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * com.lordjoe.utilities.DateUtilities
 * User: Steve
 * Date: 2/21/2019
 */
public class DateUtilities {

    @SuppressWarnings("deprecated")
    public static LocalDate to(Date d) {
        return LocalDate.of(d.getYear() + 1900,d.getMonth() + 1,d.getDate()) ;
    }

    @SuppressWarnings("deprecated")
    public static Date to(LocalDate d) {
        return new Date(d.getYear() - 1900,d.getMonth().getValue() - 1,d.getDayOfMonth()) ;
    }

    /**
     * true if the year is a leap year
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year)  {
        if(year % 4 != 0)
            return false;
        if(year % 400 != 0)
            return true;
        if(year % 100 != 0)
            return false;
        return true;
    }
    /**
     * find all mondays in the month
     * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
     * @param month the month-of-year to represent, from 1 (January) to 12 (December)
     * @return
     */
    public static List<LocalDate> mondaysIn(int year, int month) {
        Month m = Month.of(month);
        return  mondaysIn(  year, m) ;
    }
    /**
     * find all mondays in the month
     * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
     * @param month the month
     * @return  mondays before current time
     */
    public static List<LocalDate> mondaysIn(int year, Month month) {
        List<LocalDate> mondays = new ArrayList<>() ;
        for (int day = 0; day < month.length(isLeapYear(year)); day++) {
              LocalDate test = LocalDate.of(year,month, day+ 1);
              if(test.isAfter(LocalDate.now()))
                  return mondays;
              if(DayOfWeek.from(test) == DayOfWeek.MONDAY)
                  mondays.add(test);

        }
        return mondays;
    }

    /**
     * true if the dates are on the same day
     * @param d1
     * @param d2
     * @return
     */
    public static boolean sameDay(Calendar d1, Calendar d2)    {
        if(d1.get(Calendar.YEAR) != d2.get(Calendar.YEAR))
            return false;
        if(d1.get(Calendar.MONTH) != d2.get(Calendar.MONTH))
            return false;
        if(d1.get(Calendar.DATE) != d2.get(Calendar.DATE))
            return false;
        return true;
    }
}
