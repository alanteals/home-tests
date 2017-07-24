package com.mruiz84.home.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConvertDateToLongTest {

    @Test
    public void convertDateTimeToLong() {
        System.out.println("ldt " + LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println("ctm " + System.currentTimeMillis());
    }
}
