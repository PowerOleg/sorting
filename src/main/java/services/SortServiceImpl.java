package services;

import models.Item;
import repositories.Database;

import java.io.File;
import java.util.List;
import java.util.Set;

public class SortServiceImpl implements SortService {
    private Database database;

    public SortServiceImpl() {
        this.database = Database.getInstance();
    }

    @Override
    public Set<Item> getDataFromTxt(File textFile) {
        return null;
    }

    @Override
    public void writeTxt(File textFile) {

    }

    @Override
    public void parse() {

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
