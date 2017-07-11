package com.mruiz84.home.exception;

import org.junit.Test;

public class TryCatchFinallyTest {

    @Test(expected = Exception.class)
    public void m1ExceptionTest() throws Exception {
        // should print "B"
        try {
            m1();
            System.out.println("A");
        } finally {
            System.out.println("B");
        }
        System.out.println("C");
    }

    private void m1() throws Exception {
        throw new Exception();
    }
}
