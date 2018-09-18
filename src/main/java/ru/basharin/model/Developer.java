package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;

public class Developer extends NamedEntity implements  Serializable{

    private long skillsID;
    private long accountID;

    public Developer(int id, String name, long skillsID, long accountID) {
        super(id, name);
        this.skillsID = skillsID;
        this.accountID = accountID;
    }

    public long getSkillsID() {
        return skillsID;
    }

    public void setSkillsID(long skillsID) {
        this.skillsID = skillsID;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return skillsID == developer.skillsID &&
                accountID == developer.accountID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skillsID, accountID);
    }

    @Override
    public String toString() {
        return getId()+ " " + getName() + " " + skillsID + " " + accountID;
    }
}
