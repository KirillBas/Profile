package ru.basharin.view;

import ru.basharin.controller.SkillController;
import ru.basharin.model.Account;
import ru.basharin.model.Skills;

import java.util.Scanner;

public class SkillsView {
    // TODO: 28.08.2018 View для скилов

    private SkillController skillController = new SkillController();
    private Scanner scanner = new Scanner(System.in);
    private int numberID;

//    private void chooseID() {
//        skills.setId(numberID+1);
//
//    }

    public void chooseSkills(){
        Skills skills = new Skills(numberID);
        System.out.println(skills);
        String input;
        while (true) {
            System.out.println("Choose your Skills");
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
                    skills.setJava("java");
                    break;
                case "2":
                    skills.setHibernate("hibernate");
                    break;
                case "3":
                    skills.setSQL("SQL");
                    break;
                case "4":
                    skills.setMaven("maven");
                    break;
                case "5":
                    skills.setJDBC("JDBC");
                    break;
                case "6":
                    skills.setSpring("spring");
                    break;
                case "7":
                    skills.setGit("git");
                    break;
                case "#":
                    skills.setId(++numberID);
                    // TODO: 02.09.2018 файл перезаписывается это избегается если мы кладем клиента в лист и пишем его в файл
                    skillController.save(skills);
                    System.out.println(skills);
                    return;
            }
        }
    }

    public void deleteSkills() {
        System.out.println();
    }
}
