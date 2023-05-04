package ru.oleg.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.oleg.models.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class SortServiceImplTest {
    SortServiceImpl service;
    final String pathTestTxt = "src/main/resources/test.txt";

    @BeforeEach
    public void initialization() {
        service = new SortServiceImpl();
    }

    @Test
    public void test_parse_identificator_positive() {
        final int numberOfParts = 3;
        final String argument = "248-01-0045";
        int[] expected = new int[numberOfParts];
        expected[0] = 248;
        expected[1] = 1;
        expected[2] = 45;

        int[] result = service.parseIdentificator(argument);
        Assertions.assertArrayEquals(expected, result);
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
    public void test_get_data_from_positive() {
        final int numberOfElementsInTxt = 2;
        Object[] expected = new Object[numberOfElementsInTxt];
        final Se se = new Se(160, 5, 802, "SE 160-05-802");
        final Std std = new Std("C03", 0, 711, 200, "STD C03-711-200");
        expected[0] = std;
        expected[1] = se;

        final Set<Item> result = service.getDataFromTxt(new File(pathTestTxt));
        final Object[] resultArray = result.toArray();
            Assertions.assertArrayEquals(expected, resultArray);
    }
    @Test
    public void test_sort_positive() {
        final int numberOfElements = 14;
        Item[] expected = new Item[numberOfElements];
        expected[0] = new Se(160, 5, 801, "SE 160-05-801");
        expected[1] = new Se(160, 5, 802, "SE 160-05-802");
        expected[2] = new Se(204, 40, 55,"SE 204-40-055");
        expected[3] = new Se(205, 40, 50,"SE 205-40-050");
        expected[4] = new Det(248,1, 45, "DET 248-01-0045");
        expected[5] = new Det(248,2, 45, "DET 248-02-0045");
        expected[6] = new Std("C03", 0, 711, 100, "STD C03-711-100");
        expected[7] = new Std("C03", 0, 711, 200, "STD C03-711-200");
        expected[8] = new Std("C03", 1, 711, 50, "STD C03-711-01-050");
        expected[9] = new Std("C03", 0, 712, 1, "STD C03-712-001");
        expected[10] = new Std("C04", 0, 710, 100, "STD C04-710-100");
        expected[11] = new Mat("MAT Ацетон ГОСТ 18675", "Ацетон ГОСТ 18675");
        expected[12] = new Mat("MAT Ацетон ГОСТ 19675", "Ацетон ГОСТ 19675");
        expected[13] = new Mat("MAT Рукав", "Рукав");

        Set<Item> argument = new HashSet<>();
        for (int i = numberOfElements-1; i >= 0; i--) {
            argument.add(expected[i]);
        }
        Object[] resultArray = service.sort(argument).toArray();
        Assertions.assertArrayEquals(expected, resultArray);
    }

}
