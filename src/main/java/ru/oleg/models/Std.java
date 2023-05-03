package ru.oleg.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Std std = (Std) o;
        return prefix.equals(std.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prefix);
    }
}
