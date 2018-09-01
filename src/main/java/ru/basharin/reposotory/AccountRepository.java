package ru.basharin.reposotory;

import ru.basharin.model.Account;
import ru.basharin.model.Skills;

import java.util.List;

public interface AccountRepository extends GenericRepository<Account, Long> {

    @Override
    default void save(Account account) {

    }

    @Override
    default Account getByID(Long accountId) {
        return null;
    }

    @Override
    default void deleteByID(Long accountId) {

    }

    @Override
    default List<Account> readAll() {
        return null;
    }
}
