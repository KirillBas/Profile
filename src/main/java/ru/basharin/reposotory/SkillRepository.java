package ru.basharin.reposotory;

import ru.basharin.model.Skill;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SkillRepository extends GenericRepository<Skill, Long> {
    @Override
    void save(Skill skill);

    @Override
    Skill getByID(Long skillID);

    @Override
    void deleteByID(Long skillID) throws FileNotFoundException;

    @Override
    List<Skill> readAll();

    @Override
    Long getByName(Skill skill);
}
