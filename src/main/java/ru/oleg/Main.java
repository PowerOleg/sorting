package ru.oleg;

import ru.oleg.controllers.Controller;
import ru.oleg.services.SortService;
import ru.oleg.services.SortServiceImpl;

import java.io.File;

public class Main {

    public static final String FILE_PATH = "./examples/example.txt";
    public static void main(String[] args) {
        File inputFile = new File(FILE_PATH);
        SortService service = new SortServiceImpl();
        Controller controller = new Controller(service);
        controller.printItemsConsole(inputFile);
    }
}
