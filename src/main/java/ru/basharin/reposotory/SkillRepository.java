package ru.basharin.reposotory;

import ru.basharin.model.Skills;

import java.util.List;

public interface SkillRepository extends GenericRepository<Skills, Long> {
    @Override
    default void save(Skills skills) {

    }

    @Override
    default Skills getByID(Long skillID) {
        return null;
    }

    @Override
    default void deleteByID(Long skillID) {

    }

    @Override
    default List<Skills> readAll() {
        return null;
    }
}
