package ru.oleg.repositories;

import ru.oleg.models.Item;

import java.util.Optional;
import java.util.Set;

public class Database {
    private static Database instance = null;

    private static Set<Item> items = null;

    private Database() {
    }

    public static synchronized Database getInstance() {
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

    public Item getItemByName(Item item) {
        final Optional<Item> optionalItem = items.stream().filter(n -> n.equals(item)).findFirst();
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        }
        System.out.println("Такого элемента не существует");
        return null;
    }
}
