package ru.oleg;

import ru.oleg.controllers.Controller;
import ru.oleg.services.SortService;
import ru.oleg.services.SortServiceImpl;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class Main {
    public static final String FILE_PATH = "example.txt";

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource(FILE_PATH);
        final File inputFile = new File(Objects.requireNonNull(resource).getFile());

        SortService service = new SortServiceImpl();
        Controller controller = new Controller(service);
        controller.printSortedItemsConsole(inputFile);
    }
}