package ru.basharin.view;

import ru.basharin.model.Account;
import ru.basharin.model.Skill;
import ru.basharin.model.Developer;

import java.io.FileNotFoundException;
import java.util.*;

public class ConsoleHelper {

    // TODO: 28.08.2018 Это общий view, убрать детали в ссотв. разделы

    private final Scanner scanner;
    private Developer developer = null;
    private Account account = null;
    private Skill aSkill = null;
    private AccountView accountView = new AccountView();
    private SkillView skillView = new SkillView();

    public ConsoleHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() throws FileNotFoundException {
        String input;
        while (true) {
            System.out.println("Hello. Choose number in menu");
            System.out.println("Skill menu: 1");
            System.out.println("Account menu: 2");
            System.out.println("Developer menu: 3");
            System.out.println("Exit: #");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    skillView.skillsMenu();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "#":
                    return;
            }
        }
    }

    public void developerMenu() {
        String input;
        while (true) {
            System.out.println("Hello. Choose number in menu");
            System.out.println("Change name: 1");
            System.out.println("Change login: 2");
            System.out.println("Change password: 3");
            System.out.println("Change aSkill: 4");
            System.out.println("Delete account: 5");
            System.out.println("Exit: #");
            input = scanner.nextLine();
            switch (input) {
                case "1":
//                    changeName();
                    break;
                case "2":
//                    changeLogin();
                    break;
                case "3":
//                    changePassword();
                    break;
                case "4":
//                    changeSkills();
                    break;
                case "5":
//                    deleteAccount();
                    break;
                case "#":
                    return;
            }
        }
    }

}
