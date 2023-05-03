package ru.oleg.models;

import java.util.Comparator;

public class Se extends Item {
    public Se(int positionNumber, int systemNumber, int number, String fullname) {
        super(positionNumber, systemNumber, number, fullname);
        this.type = 1;
    }


}
