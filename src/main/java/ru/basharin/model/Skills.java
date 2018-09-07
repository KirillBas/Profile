package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;

public class Skills extends BaseEntity implements Serializable {

    private String customSkill;

    public Skills(int id) {
        super(id);
        this.customSkill = null;
    }

    public Skills(int id, String customSkill) {
        super(id);
        this.customSkill = customSkill;
    }

    public String getCustomSkill() {
        return customSkill;
    }

    public void setCustomSkill(String customSkill) {
        this.customSkill = customSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Skills skills = (Skills) o;
        return Objects.equals(customSkill, skills.customSkill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customSkill);
    }

    @Override
    public String toString() {
        return getId() + " " + customSkill;
    }
}
