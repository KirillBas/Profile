package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Developer implements Serializable{

    private long ID;
    private String name;
    private Skills skills;
    private Account account;

    public Developer(long ID, String name, Skills skills, Account account) {
        this.ID = ID;
        this.name = name;
        this.skills = skills;
        this.account = account;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return ID == developer.ID &&
                Objects.equals(name, developer.name) &&
                Objects.equals(skills, developer.skills) &&
                Objects.equals(account, developer.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, skills, account);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", skills=" + skills +
                ", account=" + account +
                '}';
    }
}
