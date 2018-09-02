package ru.basharin.controller;


import ru.basharin.model.Skills;
import ru.basharin.reposotory.io.JavaIOSkillRepositoryImpl;

public class SkillController {
    private JavaIOSkillRepositoryImpl javaIOSkillRepository = new JavaIOSkillRepositoryImpl();

    public void save(Skills skills) {
        if (!skills.equals(null)) {
            javaIOSkillRepository.save(skills);
        }else {
            System.out.println("Not found skills");
        }
    }

    public Object read() {
        return javaIOSkillRepository.read();
    }


}
