package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Developer implements Serializable{

    private long ID;
    private String name;
    private Set<Skills> skillsSet;
    private Account account;

    public Developer(long ID, String name, Set<Skills> skillsSet, Account account) {
        this.ID = ID;
        this.name = name;
        this.skillsSet = skillsSet;
        this.account = account;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Skills> getSkillsSet() {
        return skillsSet;
    }

    public void setSkillsSet(Set<Skills> skillsSet) {
        this.skillsSet = skillsSet;
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
                Objects.equals(skillsSet, developer.skillsSet) &&
                Objects.equals(account, developer.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, skillsSet, account);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", skillsSet=" + skillsSet +
                ", account=" + account +
                '}';
    }
}
