package ru.oleg.services;

import ru.oleg.models.Item;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface SortService {
    Set<Item> getDataFromTxt(File textFile);
    void writeTxt(File textFile);
    Item parse(String line);
    List<Item> sort();
}
