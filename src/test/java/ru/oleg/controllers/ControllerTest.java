package ru.oleg.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.oleg.models.Item;
import ru.oleg.models.Mat;
import ru.oleg.models.Se;
import ru.oleg.services.SortService;
import ru.oleg.services.SortServiceImpl;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import static org.mockito.BDDMockito.given;

public class ControllerTest {
    final String pathTestTxt = "src/main/resources/test.txt";

    @Test
    public void test_print_sorted_items_console_positive() {
        Set<Item> expected = new TreeSet<>();
        expected.add(new Se(160, 5, 802, "SE 160-05-802"));
        expected.add(new Mat("MAT Ацетон ГОСТ 18675", "Ацетон ГОСТ 18675"));

        SortService service = Mockito.mock(SortServiceImpl.class);
        given(service.sort(Mockito.any())).willReturn(expected);

        Controller controller = new Controller(service);
        Assertions.assertTrue(controller.printSortedItemsConsole(new File(pathTestTxt)));
    }
}
