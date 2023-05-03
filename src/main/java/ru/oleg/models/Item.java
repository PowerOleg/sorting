package ru.oleg.models;

import java.util.Comparator;
import java.util.Objects;

public abstract class Item implements Comparable<Item> {
    protected Integer type;
    protected final int positionNumber;
    protected final int systemNumber;
    protected final int number;
    protected final String fullname;

    public Item(int positionNumber, int systemNumber, int number, String fullname) {
        this.type = null;
        this.positionNumber = positionNumber;
        this.systemNumber = systemNumber;
        this.number = number;
        this.fullname = fullname;
    }

    @Override
    public int compareTo(Item o) {
        return Comparator.comparing(Item::getType)
                .thenComparingInt(Item::getSystemNumber)
                .thenComparingInt(Item::getPositionNumber)
                .thenComparingInt(Item::getNumber)
                .compare(this, o);
    }

    public Integer getType() {
        return type;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public int getSystemNumber() {
        return systemNumber;
    }

    public int getNumber() {
        return number;
    }

    public String getFullname() {
        return fullname;
    }

    @Override
    public String toString() {
        return fullname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return positionNumber == item.positionNumber && systemNumber == item.systemNumber && number == item.number && type.equals(item.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, positionNumber, systemNumber, number);
    }
}
