package ru.oleg.models;

import java.util.Comparator;
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
        boolean flag = false;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mat mat = (Mat) o;
        if (name.equals(mat.name)) flag = true;
        if (fullname.equals(mat.getFullname())) flag = true;
        return flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public int compareTo(Item o) {
        return Comparator.comparing(Item::getType)
                .thenComparing(Item::getFullname)
                .compare(this, o);
    }

    public String getName() {
        return name;
    }
}
