package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;

public class Developer implements Serializable{

    private final long ID;
    private final String name;
    private final long skillsID;
    private final long accountID;

    public Developer(long accountID, String name) {
        this.ID = accountID;
        this.name = name;
        this.skillsID = accountID;
        this.accountID = accountID;
    }

    public Developer(long ID, String name, long skillsID, long accountID) {
        this.ID = ID;
        this.name = name;
        this.skillsID = skillsID;
        this.accountID = accountID;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public long getSkillsID() {
        return skillsID;
    }

    public long getAccountID() {
        return accountID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return ID == developer.ID &&
                skillsID == developer.skillsID &&
                accountID == developer.accountID &&
                Objects.equals(name, developer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, skillsID, accountID);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", skillsID=" + skillsID +
                ", accountID=" + accountID +
                '}';
    }
}
