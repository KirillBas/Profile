package ru.basharin.controller;

import ru.basharin.model.Account;
import ru.basharin.model.Skills;
import ru.basharin.model.Developer;
import ru.basharin.reposotory.DeveloperRepository;

import java.util.*;

public class DeveloperController {
    private final Scanner scanner;
    private  final DeveloperRepository devRepository;
    private Skills aSkills = new Skills();
    private Set<Skills> skillsSet = new HashSet<>();
    private Account account;
    private Developer developer;

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

        account = new Account(login, pass);
//        accounts.add(account);
//        devRepository.writeAccountInFile(accounts);
//        System.out.println(accounts);
    }

    public void chooseSkills(){
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
        Random random = new Random();
        developer = new Developer(random.nextInt(), name, skillsSet, account);
        devRepository.writeDeveloperInFile(developer);
    }
}
