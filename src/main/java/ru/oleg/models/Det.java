package ru.oleg.models;

public class Det extends Item {
    public Det(int positionNumber, int systemNumber, int number, String fullname) {
        super(positionNumber, systemNumber, number, fullname);
        this.type = 2;
    }
}
