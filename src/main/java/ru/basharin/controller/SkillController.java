package ru.basharin.controller;


import ru.basharin.io.JavaIOSkillRepositoryImpl;
import ru.basharin.model.Skills;
import ru.basharin.reposotory.SkillRepository;

import java.util.HashMap;
import java.util.Map;

public class SkillController implements SkillRepository{
    private final Map<Long, Skills> skillsSet = new HashMap<>();
    private final JavaIOSkillRepositoryImpl jIOsr;

    public SkillController(JavaIOSkillRepositoryImpl jIOsr) {
        this.jIOsr = jIOsr;
        skillsSet.putAll(jIOsr.readSkillsFile());
    }

    public Map<Long, Skills> getSkillsSet() {
        return skillsSet;
    }

    @Override
    public void save(Skills skills) {

    }

    @Override
    public Skills getByID(Long id) {
        return skillsSet.get(id);
    }

    @Override
    public void deleteByID(Skills skills) {
        skillsSet.remove(skills.getId());
        jIOsr.writeSkillsInFile(skillsSet);
    }

    @Override
    public void create(Skills skills) {

    }
}
