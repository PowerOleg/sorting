package ru.oleg.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatTest {

    @Test
    public void test_se_constructor_and_getters_positive() {
        final int expectedType = 4;
        final String expectedFullname = "MAT Ацетон ГОСТ 18675";
        final String expectedName = "Ацетон ГОСТ 18675";
        final Mat mat = new Mat(expectedFullname, expectedName);

        Assertions.assertEquals(expectedFullname, mat.getFullname());
        Assertions.assertEquals(expectedName, mat.getName());
    }
}
