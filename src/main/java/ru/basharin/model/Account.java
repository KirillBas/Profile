package ru.basharin.model;

import java.io.Serializable;
import java.util.Objects;

public class Account extends BaseEntity implements Serializable{

    private String accountName;
    private String password;

    public Account(int id, String accountName, String password) {
        super(id);
        this.accountName = accountName;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
        return Objects.equals(accountName, account.accountName) &&
                Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accountName, password);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
