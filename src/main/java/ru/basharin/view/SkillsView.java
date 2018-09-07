package ru.basharin.view;

import ru.basharin.controller.SkillController;
import ru.basharin.model.Skills;

import java.util.Scanner;

class SkillsView {

    private final SkillController skillController = new SkillController();
    private final Scanner scanner = new Scanner(System.in);
    private int numberID = 0;


    private void writeSkills() {
        Skills skills = new Skills(numberID);
        String input;
        while (true) {
            System.out.println("Write your Skills");
            input = scanner.nextLine();
            if (input.equals("#")) {
                return;
            }
            skills.setId(++numberID);
            skills.setCustomSkill(input);
            skillController.save(skills);
        }
    }

    private void deleteSkills() {
        String input;
        while (true) {
            System.out.println("Write a skill that you want to remove");
            input = scanner.nextLine();
            if (input.equals("#")) {
                return;
            }
            long id = skillController.read(input);
            skillController.deleteSkills(id);
        }
    }

    private void readAll() {
        skillController.readAll();
    }

    public void skillsMenu() {
        String input;
        while (true) {
            System.out.println("Select menu item");
            System.out.println("Write skill: #1");
            System.out.println("Delete skill: #2");
            System.out.println("Read all skills: #3");
            System.out.println("Return: #4");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    writeSkills();
                    break;
                case "2":
                    deleteSkills();
                    break;
                case "3":
                    readAll();
                    break;
                case "4":
                    return;
            }
        }


    }
}
