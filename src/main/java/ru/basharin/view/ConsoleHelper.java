package ru.basharin.view;

import ru.basharin.model.Account;
import ru.basharin.model.Skill;
import ru.basharin.model.Developer;

import java.io.FileNotFoundException;
import java.util.*;

public class ConsoleHelper {

    // TODO: 28.08.2018 Это общий view, убрать детали в ссотв. разделы

    private final Scanner scanner;
    private DeveloperView developerView = new DeveloperView();
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
                    accountView.accountMenu();
                    break;
                case "3":
                    developerView.skillsMenu();
                    break;
                case "#":
                    return;
            }
        }
    }
}
