package ru.basharin.view;

import ru.basharin.controller.SkillController;
import ru.basharin.model.Skill;

import java.util.List;
import java.util.Scanner;

class SkillView {

    private final SkillController skillController = new SkillController();
    private final Scanner scanner = new Scanner(System.in);
    private int numberID = 0;


    private void writeSkills() {
        Skill skill = new Skill(numberID,null);
        String input;
        while (true) {
            System.out.println("Write your Skill");
            input = scanner.nextLine();
            if (input.equals("#")) {
                return;
            }
            skill.setId(++numberID);
            skill.setName(input);
            skillController.save(skill);
        }
    }

    private void deleteSkills() {
        Skill skill = new Skill(numberID,null);
        String input;
        while (true) {
            System.out.println("Write a skill that you want to remove");
            input = scanner.nextLine();
            if (input.equals("#")) {
                return;
            }
            skill.setName(input);
            long id = skillController.read(skill);
            skillController.deleteSkills(id);
        }
    }

    private List<Skill> readAll() {
        return skillController.readAll();
    }

    void skillsMenu() {
        String input;
        while (true) {
            System.out.println("Select menu item");
            System.out.println("Write skill: #1");
            System.out.println("Delete skill: #2");
            System.out.println("Read all skills: #3");
            System.out.println("Return: #");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    writeSkills();
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
