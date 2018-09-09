package ru.basharin.reposotory;

import ru.basharin.model.Skill;

import java.util.List;

public interface SkillRepository extends GenericRepository<Skill, Long> {
    @Override
    void save(Skill skill);

    @Override
    Skill getByID(Long skillID);

    @Override
    void deleteByID(Long skillID);

    @Override
    List<Skill> readAll();

    @Override
    Long getByName(Skill skill);
}
