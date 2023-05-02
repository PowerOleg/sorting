package controllers;

import services.SortService;

public class controller {
    private SortService service;

    public controller(SortService service) {
        this.service = service;
    }

    public void printItems() {

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
