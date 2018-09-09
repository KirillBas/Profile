package ru.basharin.reposotory;

import ru.basharin.model.Account;

import java.util.List;

public interface AccountRepository extends GenericRepository<Account, Long> {

    @Override
    void save(Account account);

    @Override
    Account getByID(Long accountId);

    @Override
    void deleteByID(Long accountId);

    @Override
    List<Account> readAll();
}
