package ru.basharin.reposotory;

import ru.basharin.model.Developer;

public interface DevRepository extends GenericRepository<Developer, Long> {

    @Override
    default void save(Developer developer) {

    }

    @Override
    default Developer getByID(Long aLong) {
        return null;
    }

    @Override
    default void deleteByID(Developer developer) {

    }

    @Override
    default void create(Developer developer) {

    }
}
