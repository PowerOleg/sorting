package ru.oleg.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StdTest {

    @Test
    public void test_se_constructor_and_getters_positive() {
        final int expectedType = 3;
        final String expectedPrefix = "C03";
        final int expectedRegistration = 55;
        final int expectedRevision = 2;
        final int expectedSize = 200;
        final String expectedFullname = "STD C03-055-02-200";
        final Std std = new Std(expectedPrefix, expectedRevision, expectedRegistration, expectedSize, expectedFullname);

        Assertions.assertEquals(expectedRevision, std.getPositionNumber());
        Assertions.assertEquals(expectedRegistration, std.getSystemNumber());
        Assertions.assertEquals(expectedSize, std.getNumber());
        Assertions.assertEquals(expectedType, std.getType());
        Assertions.assertEquals(expectedPrefix, std.getPrefix());
        Assertions.assertEquals(expectedFullname, std.getFullname());
    }
}
