package ru.basharin;

import ru.basharin.controller.SkillController;
import ru.basharin.view.ConsoleHelper;
import ru.basharin.view.SkillsView;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ConsoleHelper consoleHelper = new ConsoleHelper(scanner);
        SkillController skillController = new SkillController();

        consoleHelper.run();
        System.out.println(skillController.read());

    }
}
