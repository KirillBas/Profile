package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;

public class Skill extends NamedEntity implements Serializable {

    public Skill(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " ";
    }
}
