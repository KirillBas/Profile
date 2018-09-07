package ru.basharin.controller;


import ru.basharin.model.Skills;
import ru.basharin.reposotory.io.JavaIOSkillRepositoryImpl;

import java.util.List;

public class SkillController {
    private JavaIOSkillRepositoryImpl javaIOSkillRepository = new JavaIOSkillRepositoryImpl();

    public void save(Skills skills) {
        if (!skills.equals(null)) {
            javaIOSkillRepository.save(skills);
        }else {
            System.out.println("Not found skills");
        }
    }

    public long read(String skills) {
        List<Skills> skillsList = javaIOSkillRepository.readAll();
        for (Skills result : skillsList) {
            if (result.equals(skills)) {
                return result.getId();
            }
        }
        return 0;
    }

    public void deleteSkills(long id) {
        javaIOSkillRepository.deleteByID(id);
    }

    public List<Skills> readAll() {
        return javaIOSkillRepository.readAll();
    }
}
