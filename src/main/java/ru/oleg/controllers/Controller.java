package ru.oleg.controllers;

import ru.oleg.models.Item;
import ru.oleg.repositories.Database;
import ru.oleg.services.SortService;

import java.io.File;
import java.util.Set;

public class Controller {
    private SortService service;

    public Controller(SortService service) {
        this.service = service;
    }

    public boolean printItemsConsole(File textFile) {
        final Set<Item> dataFromTxt = service.getDataFromTxt(textFile);
        service.print(dataFromTxt);
        return true;
    }

    public boolean printSortedItemsConsole(File textFile) {
        Database database = Database.getInstance();
        database.setItems(service.getDataFromTxt(textFile));
        service.print(service.sort(database.getItems()));
        return true;
    }

    public SortService getService() {
        return service;
    }

    public void setService(SortService service) {
        this.service = service;
    }
}
