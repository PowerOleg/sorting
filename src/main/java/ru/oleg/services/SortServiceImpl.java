package ru.oleg.services;

import ru.oleg.models.Det;
import ru.oleg.models.Item;
import ru.oleg.models.Se;
import ru.oleg.repositories.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortServiceImpl implements SortService {
    private Database database;

    public SortServiceImpl() {
        this.database = Database.getInstance();
    }

    @Override
    public Set<Item> getDataFromTxt(File textFile) {
        Set<Item> items = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals(" ") || !line.equals("\n")) {
                    items.add(parse(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void writeTxt(File textFile) {
    }

    @Override
    public Item parse(String line) {
        final String[] stringArray = line.split(" ");
        final String[] numbersInString = stringArray[0].split("-");
        int[] numbers = new int[numbersInString.length];
        if (numbersInString.length != 3) {
            System.out.println("Не корректный идентификатор изделия");
        }
        try {
            for (int i = 0; i < numbersInString.length; i++) {
                numbers[i] = Integer.parseInt(numbersInString[i]);
            }
        } catch (RuntimeException e) {
            System.out.println("В идентификатор введена не цифра");
            e.printStackTrace();
        }

        switch (stringArray[0]) {
            case "SE":
                return new Se(numbers[0], numbers[1], numbers[2]);

            case "DET":
                return new Det(numbers[0], numbers[1], numbers[2]);

            default:
                System.out.println("Тип изделия не определен");
                break;
        }

        return null;
    }

    @Override
    public List<Item> sort() {
        return null;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
