package ru.oleg.services;

import ru.oleg.models.Item;

import java.io.File;
import java.util.Collection;
import java.util.Set;

public interface SortService {
    Set<Item> getDataFromTxt(File textFile);

    Item parse(String line);

    Set<Item> sort(Set<Item> set);

    void print(Collection<Item> objects);
}
