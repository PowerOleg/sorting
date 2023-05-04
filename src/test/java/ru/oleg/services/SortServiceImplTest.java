package ru.oleg.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.oleg.models.Item;
import ru.oleg.models.Mat;
import ru.oleg.models.Se;

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
