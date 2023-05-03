package ru.oleg.services;

import ru.oleg.models.Det;
import ru.oleg.models.Item;
import ru.oleg.models.Se;
import ru.oleg.repositories.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SortServiceImpl implements SortService {
    @Override
    public Set<Item> getDataFromTxt(File textFile) {
        Set<Item> items = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() > 4) {
                    items.add(parse(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item parse(String line) {
        final String[] stringArray = line.split(" ");
        final String[] numbersInString = stringArray[1].split("-");
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
                return new Se(numbers[0], numbers[1], numbers[2], line);

            case "DET":
                return new Det(numbers[0], numbers[1], numbers[2], line);

            default:
                System.out.println("Тип изделия не определен");
                break;
        }

        return null;
    }

    @Override
    public List<Item> sort(Set<Item> items) {
        Comparator<Item> itemComparator = new ItemComparator();
//        Comparator<Item> itemComparator = new ItemComparator();

//        = new ArrayList<>(items);
//        sortedItems.sort();
                List<Item> sortedItems = items.stream().sorted(itemComparator)
//                                                        .sorted()
                                                        .collect(Collectors.toList());

        return sortedItems;
    }

    @Override
    public void print(Collection<Item> objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}

class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
//class PositionNumberComparator implements Comparator<Item> {
//    @Override
//    public int compare(Item o1, Item o2) {
//        return 0;
//    }
//}
//class SystemNumberComparator implements Comparator<Item> {
//    @Override
//    public int compare(Item o1, Item o2) {
//        return 0;
//    }
//}
//class NumberComparator implements Comparator<Item> {
//    @Override
//    public int compare(Item o1, Item o2) {
//        return 0;
//    }
//}
