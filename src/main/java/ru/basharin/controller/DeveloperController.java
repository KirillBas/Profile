package ru.basharin.controller;

import ru.basharin.model.Account;
import ru.basharin.model.Skills;
import ru.basharin.model.Developer;
import ru.basharin.reposotory.DevRepository;
import ru.basharin.reposotory.DeveloperRepository;

import java.util.*;

public class DeveloperController implements DevRepository{
    // TODO: 28.08.2018 Здесь только обработка запросов Developer все остальное перенести в ConsoleHelper по идее должен имплементировать интерфейс DevRepository
    private final Scanner scanner;
    private final DeveloperRepository devRepository;
    private Account account;
    private Set<Skills> skillsSet = new HashSet<>();

    public DeveloperController(Scanner scanner, DeveloperRepository devRepository) {
        this.scanner = scanner;
        this.devRepository = devRepository;
    }

    public void createAccount() {
        String login;
        while (true) {
            System.out.println("Write login");
            login = scanner.nextLine();
            if (login.equals("#")) {
                return;
            }
            break;
            // TODO: 18.08.2018 написать валидацию логина
        }

        String pass;
        while (true) {
            System.out.println("Write password");
            pass = scanner.nextLine();
            if (pass.equals("#")) {
                return;
            }
            break;
        }

        String ID;
        while (true) {
            System.out.println("Write ID");
            ID = scanner.nextLine();
            if (ID.equals("#")){
                return;
            }
            break;
        }

        account = new Account(Long.parseLong(ID), login, pass);
    }

    public void chooseSkills(){
        Skills aSkills = new Skills(account.getId());
        String input;
        skillsSet.add(aSkills);
        while (true) {
            System.out.println("Choose your aSkills");
            System.out.println("java: 1");
            System.out.println("hibernate: 2");
            System.out.println("SQL: 3");
            System.out.println("maven: 4");
            System.out.println("JDBC: 5");
            System.out.println("spring: 6");
            System.out.println("git: 7");
            System.out.println("Exit: #");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    aSkills.setJava("java");
                    break;
                case "2":
                    aSkills.setHibernate("hibernate");
                    break;
                case "3":
                    aSkills.setSQL("SQL");
                    break;
                case "4":
                    aSkills.setMaven("maven");
                    break;
                case "5":
                    aSkills.setJDBC("JDBC");
                    break;
                case "6":
                    aSkills.setSpring("spring");
                    break;
                case "7":
                    aSkills.setGit("git");
                    break;
                case "#":
                    return;
            }
        }
    }

    public void createDeveloper() {
        String name;
        while (true) {
            System.out.println("Write name");
            name = scanner.nextLine();
            if (name.equals("#")) {
                return;
            }
            break;
        }

        // TODO: 28.08.2018 разобраться что мы сохраняем
        Developer developer = new Developer(account.getId(), "Kirill");
        devRepository.writeDeveloperInFile(developer);
    }
}
