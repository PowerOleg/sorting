package ru.oleg.models;

import java.util.Objects;

public class Mat extends Item {
    protected final String name;
    public Mat(String fullname, String name) {
        super(0, 0, 0, fullname);
        this.name = name;
        this.type = 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mat mat = (Mat) o;
        return name.equals(mat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
