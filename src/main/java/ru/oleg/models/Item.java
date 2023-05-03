package ru.oleg.models;

import java.util.Objects;

public abstract class Item {
    private final String type;
    private final int positionNumber;
    private final int systemNumber;
    private final int number;
    private final String fullname;

    public Item(String type, int positionNumber, int systemNumber, int number, String line) {
        this.type = type;
        this.positionNumber = positionNumber;
        this.systemNumber = systemNumber;
        this.number = number;
        this.fullname = line;
    }

    public String getType() {
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
        return positionNumber == item.positionNumber && systemNumber == item.systemNumber && number == item.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionNumber, systemNumber, number);
    }
}
