package com.lordjoe.utilities;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

/**
 * com.lordjoe.utilities.DateUtilitiesTest
 * User: Steve
 * Date: 2/21/2019
 */
public class DateUtilitiesTest {

    public static final LocalDate[] ANSWER_2018_5 = {
            LocalDate.of(2018,5,7),
            LocalDate.of(2018,5,14),
            LocalDate.of(2018,5,21),
            LocalDate.of(2018,5,28),

    };
    public static final LocalDate[] ANSWER_2018_12 = {
            LocalDate.of(2018,12,3),
            LocalDate.of(2018,12,10),
            LocalDate.of(2018,12,17),
            LocalDate.of(2018,12,24),
            LocalDate.of(2018,12,31),
    };
    @Test
    public  void testMondays()
    {
        Assert.assertArrayEquals(ANSWER_2018_5,DateUtilities.mondaysIn(2018,5).toArray());
        Assert.assertArrayEquals(ANSWER_2018_12,DateUtilities.mondaysIn(2018,12).toArray());
    }

    @Test
    public  void testConversion()
    {
         LocalDate d1 = LocalDate.of(2018,5,13);
         Date d = DateUtilities.to(d1) ;
        LocalDate d2 = DateUtilities.to(d);
         Assert.assertEquals(d1,d2);

    }
}
