package ru.basharin.controller;

import ru.basharin.model.Account;
import ru.basharin.model.Developer;
import ru.basharin.reposotory.io.JavaIODeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {

    private JavaIODeveloperRepositoryImpl javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();

    public void save(Developer developer) {
        if (developer == null) throw new IllegalArgumentException();
        javaIODeveloperRepository.save(developer);
    }

    public long readDeveloper(Developer developer) {
        return javaIODeveloperRepository.getByName(developer);
    }

    public void deleteDeveloper(long id) {
        javaIODeveloperRepository.deleteByID(id);
    }

    public List<Developer> readAll() {
        return javaIODeveloperRepository.readAll();
    }

}
