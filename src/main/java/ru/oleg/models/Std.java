package ru.oleg.models;

public class Std extends Item {
    protected final String prefix;
    public Std(String prefix, int positionNumber, int systemNumber, int number, String fullname) {
        super(positionNumber, systemNumber, number, fullname);
        this.prefix = prefix;
        this.type = 3;
    }

    public String getPrefix() {
        return prefix;
    }
}
