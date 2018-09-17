package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;

public class Account extends NamedEntity implements Serializable{

    private String password;

    public Account(int id, String name, String password) {
        super(id, name);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Account account = (Account) o;
        return Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), password);
    }

    @Override
    public String toString() {
        return  getId()+ " " + getName()+ " " + password;
    }
}
