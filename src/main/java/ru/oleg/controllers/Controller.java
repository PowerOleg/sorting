package ru.oleg.controllers;

import ru.oleg.models.Item;
import ru.oleg.services.SortService;

import java.io.File;
import java.util.Set;

public class Controller {
    private SortService service;

    public Controller(SortService service) {
        this.service = service;
    }

    public void printItemsConsole(File textFile) {
        final Set<Item> dataFromTxt = service.getDataFromTxt(textFile);
        System.out.println(dataFromTxt);
    }

    public void writeItems() {

    }

    public void writeSortedItems() {

    }

    public SortService getService() {
        return service;
    }

    public void setService(SortService service) {
        this.service = service;
    }
}
