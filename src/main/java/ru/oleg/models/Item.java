package ru.oleg.models;

public abstract class Item {
    private final int positionNumber;
    private final int systemNumber;
    private final int number;
    private final String fullname;

    public Item(int positionNumber, int systemNumber, int number) {
        this.positionNumber = positionNumber;
        this.systemNumber = systemNumber;
        this.number = number;
        this.fullname = String.valueOf(positionNumber + systemNumber + number);
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
}
