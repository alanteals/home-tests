package com.mruiz84.home.string;

import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class StringSwitchVsStringIfTest {

    private final String STR = "String";

    @Test
    public void switchTest() {
        LocalTime start = LocalTime.now();
        switch (STR) {
            case "Bye":
                dummyMethod();
                break;
            case "Hello":
                dummyMethod();
                break;
            case "GoodBye":
                dummyMethod();
                break;
            case "Hi":
                dummyMethod();
                break;
            case "Good Morning":
                dummyMethod();
                break;
            case "Good Afternoon":
                dummyMethod();
                break;
            case "Goof Evening":
                dummyMethod();
                break;
            case "Good Night":
                dummyMethod();
                break;
        }
        LocalTime end = LocalTime.now();
        long milliseconds = ChronoUnit.MILLIS.between(start, end);
        System.out.println("Switch: " + milliseconds + "ms");
    }

    @Test
    public void ifTest() {
        LocalTime start = LocalTime.now();
        if ("Bye".equals(STR)) {
            dummyMethod();
        } else if ("Hello".equals(STR)) {
            dummyMethod();
        } else if ("GoodBye".equals(STR)) {
            dummyMethod();
        } else if ("Hi".equals(STR)) {
            dummyMethod();
        } else if ("Good Morning".equals(STR)) {
            dummyMethod();
        } else if ("Good Afternoon".equals(STR)) {
            dummyMethod();
        } else if ("Goof Evening".equals(STR)) {
            dummyMethod();
        } else if ("Good Night".equals(STR)) {
            dummyMethod();
        }
        LocalTime end = LocalTime.now();
        long milliseconds = ChronoUnit.MILLIS.between(start, end);
        System.out.println("if-else: " + milliseconds + "ms");
    }

    private void dummyMethod() {
    }
}
