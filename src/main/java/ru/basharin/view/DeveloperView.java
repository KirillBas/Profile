package ru.basharin.view;

import ru.basharin.controller.DeveloperController;
import ru.basharin.model.Developer;

import java.util.List;
import java.util.Scanner;

public class DeveloperView {

    private final DeveloperController developerController = new DeveloperController();
    private Scanner scanner = new Scanner(System.in);
    private int numberId = 0;

    private void writeDeveloper() {
        Developer developer = new Developer(numberId,null,0,0);

        developer.setId(++numberId);

        String name;
        while (true) {
            System.out.println("Write your name");
            name = scanner.nextLine();
            if (name.equals("#")) {
                return;
            }
            developer.setName(name);
            break;
        }

        String skillId;
        while (true) {
            System.out.println("Write skill ID");
            skillId = scanner.nextLine();
            if (skillId.equals("#")) {
                return;
            }
            developer.setSkillsID(Long.parseLong(skillId));
            break;
        }

        String accountId;
        while (true) {
            System.out.println("Write account ID");
            accountId = scanner.nextLine();
            if (accountId.equals("#")) {
                return;
            }
            developer.setAccountID(Long.parseLong(accountId));
            break;
        }
        developerController.save(developer);
    }

    private void deleteSkills() {
        Developer developer = new Developer(numberId,null,0,0);
        String input;
        while (true) {
            System.out.println("Write a skill that you want to remove");
            input = scanner.nextLine();
            if (input.equals("#")) {
                return;
            }
            developer.setName(input);
            long id = developerController.readDeveloper(developer);
            developerController.deleteDeveloper(id);
        }
    }

    private List<Developer> readAll() {
        System.out.println("List of developer");
        return developerController.readAll();
    }

    void skillsMenu() {
        String input;
        while (true) {
            System.out.println("Select menu item");
            System.out.println("Create developer: #1");
            System.out.println("Delete developer: #2");
            System.out.println("Read all developers: #3");
            System.out.println("Return: #");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    writeDeveloper();
                    break;
                case "2":
                    deleteSkills();
                    break;
                case "3":
                    System.out.println(readAll());
                    break;
                case "#":
                    return;
            }
        }
    }
}
