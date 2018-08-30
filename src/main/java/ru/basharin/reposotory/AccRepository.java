package ru.basharin.reposotory;

import ru.basharin.model.Skills;

public interface AccRepository extends GenericRepository<Skills, Long> {

    @Override
    default void save(Skills skills) {

    }

    @Override
    default Skills getByID(Long aLong) {
        return null;
    }

    @Override
    default void deleteByID(Skills skills) {

    }

    @Override
    default void create(Skills skills) {

    }
}
