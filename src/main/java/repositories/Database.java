package repositories;

import models.Item;

import java.util.Set;

public class Database {
    private static Database instance = null;

    private static Set<Item> items = null;

    private Database() {
    }

    public static synchronized Database get() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        Database.items = items;
    }
}
