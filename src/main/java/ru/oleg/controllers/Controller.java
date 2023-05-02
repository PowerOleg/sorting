package ru.oleg.controllers;

import ru.oleg.services.SortService;

import java.io.File;

public class Controller {
    private SortService service;

    public Controller(SortService service) {
        this.service = service;
    }

    public void printItemsConsole(File textFile) {
        System.out.println(service.getDataFromTxt(textFile));
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
