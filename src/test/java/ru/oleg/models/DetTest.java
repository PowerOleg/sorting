package ru.oleg.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DetTest {

    @Test
    public void test_det_constructor_and_getters_positive() {
        final int expectedType = 2;
        final int expectedPosition = 100;
        final int expectedSystem = 20;
        final int expectedNumber = 1;
        final String expectedFullname = "DET 100-20-0001";
        final Det det = new Det(expectedPosition, expectedSystem, expectedNumber, expectedFullname);

        Assertions.assertEquals(expectedPosition, det.getPositionNumber());
        Assertions.assertEquals(expectedSystem, det.getSystemNumber());
        Assertions.assertEquals(expectedNumber, det.getNumber());
        Assertions.assertEquals(expectedType, det.getType());
        Assertions.assertEquals(expectedFullname, det.getFullname());
    }
}
