package ru.oleg.models;

public class Mat extends Item {
    protected String material;
    public Mat(String material, String fullname) {
        super(0, 0, 0, fullname);
        this.material = material;
        this.type = 4;
    }
}
