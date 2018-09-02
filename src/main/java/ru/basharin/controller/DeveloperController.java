package ru.basharin.controller;

import ru.basharin.reposotory.io.JavaIODeveloperRepositoryImpl;

public class DeveloperController {

    private JavaIODeveloperRepositoryImpl javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();

    public void addDevelopers() {
        javaIODeveloperRepository.readAll();
    }

}
