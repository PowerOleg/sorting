package ru.oleg.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatTest {
    @Test
    public void test_se_constructor_and_getters_positive() {
        final int expectedType = 1;
        final int expectedPosition = 100;
        final int expectedSystem = 20;
        final int expectedNumber = 700;
        final String expectedFullname = "SE 100-20-700";
        final Se se = new Se(expectedPosition, expectedSystem, expectedNumber, expectedFullname);

        Assertions.assertEquals(expectedPosition, se.getPositionNumber());
        Assertions.assertEquals(expectedSystem, se.getSystemNumber());
        Assertions.assertEquals(expectedNumber, se.getNumber());
        Assertions.assertEquals(expectedType, se.getType());
        Assertions.assertEquals(expectedFullname, se.getFullname());
    }
}
