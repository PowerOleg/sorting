package ru.oleg.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.oleg.models.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class SortServiceImplTest {
    SortServiceImpl service;

    @BeforeEach
    public void initialization() {
        service = new SortServiceImpl();
    }

    @Test
    public void test_parse_positive() {
        final int numberOfElements = 4;
        final Item[] expected = new Item[numberOfElements];
        expected[0] = new Se(205, 40, 50,"SE 205-40-050");
        expected[1] = new Det(248,1, 45, "DET 248-01-0045");
        expected[2] = new Std("C03", 0,711, 200, "STD C03-711-200");
        expected[3] = new Mat("MAT Рукав", "Рукав");

        String[] names = new String[numberOfElements];
        names[0] = "SE 205-40-050";
        names[1] = "DET 248-01-0045";
        names[2] = "STD C03-711-200";
        names[3] = "MAT Рукав";

        Item[] result = new Item[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            result[i] = service.parse(names[i]);
        }
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void test_get_data_from_txt_positive() {
        final int numberOfElementsInTxt = 2;
        Object[] expected = new Object[numberOfElementsInTxt];
        final Se se = new Se(160, 5, 802, "SE 160-05-802");
        final Mat mat = new Mat("MAT Ацетон ГОСТ 18675", "Ацетон ГОСТ 18675");
        expected[0] = mat;
        expected[1] = se;

        final Set<Item> result = service.getDataFromTxt(new File("src/main/resources/test.txt"));
        final Object[] resultArray = result.toArray();
            Assertions.assertArrayEquals(expected, resultArray);
    }
}
