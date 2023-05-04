package ru.oleg.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.oleg.models.Item;
import ru.oleg.models.Se;

import java.util.HashSet;
import java.util.Set;

public class DatabaseTest {

    @Test
    public void test_setter_and_getter_positive() {
        Set<Item> expected = new HashSet<>();
        expected.add(new Se(160, 5, 801, "SE 160-05-801"));

        Assertions.assertTrue(Database.getInstance().setItems(expected));
        Set<Item> result = Database.getInstance().getItems();
        Assertions.assertEquals(expected, result);
    }




}
