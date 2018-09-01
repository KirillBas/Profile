package ru.basharin.reposotory;

import ru.basharin.model.Developer;

import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer, Long> {

    @Override
    default void save(Developer developer) {

    }

    @Override
    default Developer getByID(Long aLong) {
        return null;
    }

    @Override
    default void deleteByID(Long aLong) {

    }

    @Override
    default List<Developer> readAll() {
        return null;
    }
}
