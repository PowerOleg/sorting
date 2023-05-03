package ru.oleg.services;

import ru.oleg.models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


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

        int[] numbers = null;
        switch (stringArray[0]) {
            case "SE":
                numbers = parseIdentificator(stringArray[1]);
                return new Se(numbers[0], numbers[1], numbers[2], line);

            case "DET":
                numbers = parseIdentificator(stringArray[1]);
                return new Det(numbers[0], numbers[1], numbers[2], line);

            case "STD":
                final String[] numbersInString = stringArray[1].split("-");
                if (numbersInString.length == 3) {
                    return new Std(numbersInString[0], 0, Integer.parseInt(numbersInString[1]),
                            Integer.parseInt(numbersInString[2]), line);
                }

                if (numbersInString.length == 4) {
                    return new Std(numbersInString[0], Integer.parseInt(numbersInString[2]),
                            Integer.parseInt(numbersInString[1]), Integer.parseInt(numbersInString[3]), line);
                }
                break;

            case "MAT":
                if (stringArray.length == 2) {
                    return new Mat(line, null);
                }
                if (stringArray.length > 2) {
                    int index = line.indexOf(" ", line.indexOf(" ")+1);
                    return new Mat(line, line.substring(index+1));
                }
                return new Mat(line, null);

            default:
                System.out.println("Тип изделия не определен");
                break;
        }
        return null;
    }

    public int[] parseIdentificator(String identificator) {
        final String[] numbersInString = identificator.split("-");
        int[] numbers = new int[numbersInString.length];
        if (numbersInString.length != 3) {
            throw new RuntimeException("Не корректный идентификатор изделия");
        }
        try {
            for (int i = 0; i < numbersInString.length; i++) {
                numbers[i] = Integer.parseInt(numbersInString[i]);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("В идентификатор введена не цифра");
        }
        return numbers;
    }

    @Override
    public Set<Item> sort(Set<Item> items) {
//        Comparator<Item> itemComparator = new ItemComparator();
////        Comparator<Std> stdComparator = new StdComparator();

//        = new ArrayList<>(items);
//        sortedItems.sort();
//        List<Item> sortedItems = items.stream().sorted(itemComparator
//                        .thenComparing(Item::getSystemNumber)
//                        .thenComparing(Item::getPositionNumber)
//                        .thenComparing(Item::getNumber))

//                                                .collect(Collectors.toList());
//        sortedItems.stream().sorted(stdComparator).collect(Collectors.toList());
        Set<Item> sortedSet = new TreeSet<>(items);

        return sortedSet;
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
//class StdComparator implements Comparator<Std> {
//    @Override
//    public int compare(Std o1, Std o2) {
//        return o1.getPrefix().compareTo(o2.getPrefix());
//    }
//}


//class PositionNumberComparator implements Comparator<Item> {
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
