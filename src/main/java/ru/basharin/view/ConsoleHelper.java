package ru.basharin.view;

import ru.basharin.controller.DeveloperController;
import ru.basharin.model.Account;
import ru.basharin.model.Skills;
import ru.basharin.model.Developer;

import java.util.*;

public class ConsoleHelper {

    // TODO: 28.08.2018 Это общий view, убрать детали в ссотв. разделы

    private final Scanner scanner;
    private Developer developer = null;
    private Account account = null;
    private Skills aSkills = null;
    private final DeveloperController devController;

    public ConsoleHelper(Scanner scanner, DeveloperController devController) {
        this.scanner = scanner;
        this.devController = devController;
    }

    public void run() {
        String input;
        while (true) {
            System.out.println("Hello. Choose number in menu");
            System.out.println("Sign in: 1");
            System.out.println("Sign up: 2");
            System.out.println("Exit: #");
            input = scanner.nextLine();
            switch (input) {
                case "1":
//                    signIn();
                    break;
                case "2":
                    devController.createAccount();
                    devController.chooseSkills();
                    devController.createDeveloper();

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
            System.out.println("Change aSkills: 4");
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
