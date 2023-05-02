package services;

import models.Item;
import repositories.Database;

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
