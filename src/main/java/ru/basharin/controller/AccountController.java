package ru.basharin.controller;

import ru.basharin.model.Account;
import ru.basharin.reposotory.io.JavaIOAccountRepositoryImpl;

import java.util.List;

public class AccountController {

    private JavaIOAccountRepositoryImpl javaIOAccountRepository = new JavaIOAccountRepositoryImpl();

    public void save(Account account) {
        if (account == null) throw new IllegalArgumentException();
        javaIOAccountRepository.save(account);
    }

    public long readAccount(Account account) {
        return javaIOAccountRepository.getByName(account);
    }

    public void deleteAccount(long id) {
        javaIOAccountRepository.deleteByID(id);
    }

    public List<Account> readAll() {
        return javaIOAccountRepository.readAll();
    }
}
