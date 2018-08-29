package ru.basharin.controller;


import ru.basharin.io.JavaIOSkillRepositoryImpl;
import ru.basharin.model.Skills;
import ru.basharin.reposotory.SkillRepository;

public class SkillController implements SkillRepository{
    // TODO: 28.08.2018 Здесь только обработка запросов Skill все остальное перенести в ConsoleHelper

    JavaIOSkillRepositoryImpl jIOsr = new JavaIOSkillRepositoryImpl();

    @Override
    public void save(Skills skills) {

    }

    @Override
    public Skills getByID(Long aLong) {
        return null;
    }

    @Override
    public void deleteByID(Long aLong) {

    }

    @Override
    public void create(Skills skills) {

    }
}
