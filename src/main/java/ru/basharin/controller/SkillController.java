package ru.basharin.controller;


import ru.basharin.model.Skill;
import ru.basharin.reposotory.SkillRepository;
import ru.basharin.reposotory.io.JavaIOSkillRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.List;

public class SkillController {
    private JavaIOSkillRepositoryImpl skillRepository = new JavaIOSkillRepositoryImpl();

    public void save(Skill skill) {
        if (skill == null) throw new IllegalArgumentException();
        skillRepository.save(skill);
    }

    public long read(Skill skill) {
        return skillRepository.getByName(skill);
    }

    public void deleteSkills(long id) throws FileNotFoundException {
        skillRepository.deleteByID(id);
    }

    public List<Skill> readAll() {
        return skillRepository.readAll();
    }
}
