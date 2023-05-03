package ru.oleg;

import ru.oleg.controllers.Controller;
import ru.oleg.services.SortService;
import ru.oleg.services.SortServiceImpl;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Objects;

public class Main {
    public static final String BASE_PACKAGE = "";
    public static void main(String[] args) {
        File inputFile = null;
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();


        final URL resource = classLoader.getResource("example.txt");

        final File file = new File(Objects.requireNonNull(resource).getFile());

        SortService service = new SortServiceImpl();
        Controller controller = new Controller(service);
        controller.printSortedItemsConsole(file);


    }
    }