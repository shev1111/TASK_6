package com.shev.long_multiplication;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class LongMultiplicationTest {
    @Test
    public void generalPrintTest() {
        int testValue_1 = 456;
        int testValue_2 = -852;
        String expPrintResult =
                "    456\n" +
                "   -852\n" +
                "-------\n" +
                "    912\n" +
                "  2280\n" +
                " 3648\n" +
                "-------\n" +
                "-388512";
        LongMultiplication multiplication = new LongMultiplication(testValue_1, testValue_2);
        assertTrue(expPrintResult.equals(multiplication.print()));
    }

    @Test
    public void PrintTestWithOne() {
        int testValue_1 = 1;
        int testValue_2 = 15;
        String expPrintResult =
                        "15\n" +
                        " 1\n" +
                        "--\n" +
                        "15";
        LongMultiplication multiplication = new LongMultiplication(testValue_1, testValue_2);
        assertTrue(expPrintResult.equals(multiplication.print()));
    }

    @Test
    public void PrintTestWithZero() {
        int testValue_1 = 0;
        int testValue_2 = 15;
        String expPrintResult =
                        "15\n" +
                        " 0\n" +
                        "--\n" +
                        " 0";
        LongMultiplication multiplication = new LongMultiplication(testValue_1, testValue_2);
        assertTrue(expPrintResult.equals(multiplication.print()));
    }

}
