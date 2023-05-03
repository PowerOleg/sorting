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
    public static final String BASE_PACKAGE = "ru.oleg.examples";
    public static void main(String[] args) {
        File inputFile = null;
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try {
            Enumeration<URL> resources = classLoader.getResources(BASE_PACKAGE.replace('.', '/'));
            while (resources.hasMoreElements()) {
                File dir = new File(resources.nextElement().toURI());
//                for (File f : Objects.requireNonNull(dir.listFiles())) {
                    inputFile = dir;
////                    if (f.getName().endsWith("txt")) {
////                        String fileName = f.getName().substring(0, f.getName().lastIndexOf("."));
////                    }
//                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

            SortService service = new SortServiceImpl();
            Controller controller = new Controller(service);
            controller.printSortedItemsConsole(inputFile);
        }
    }