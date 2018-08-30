package ru.basharin.controller;

import ru.basharin.model.Developer;
import ru.basharin.reposotory.DevRepository;

import java.util.*;

public class DeveloperController implements DevRepository{
    private final Map<Long, Developer> developers = new HashMap<>();
    public DeveloperController(Scanner scanner) {
        Scanner scanner1 = scanner;
    }

    @Override
    public void save(Developer developer) {

    }

    @Override
    public Developer getByID(Long aLong) {
        return null;
    }

    @Override
    public void deleteByID(Developer developer) {

    }

    @Override
    public void create(Developer developer) {

    }

    //    public void createDeveloper() {
//        String name;
//        while (true) {
//            System.out.println("Write name");
//            name = scanner.nextLine();
//            if (name.equals("#")) {
//                return;
//            }
//            break;
//        }
//
//        // TODO: 28.08.2018 разобраться что мы сохраняем
//        Developer developer = new Developer(account.getId(), "Kirill");
//    }
}
