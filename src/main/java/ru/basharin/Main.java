package ru.basharin;

import ru.basharin.model.Skills;
import ru.basharin.reposotory.SkillsRepository;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        DeveloperRepository dr = new DeveloperRepository();
//        DeveloperController dc = new DeveloperController(scanner, dr);
//        ConsoleHelper view = new ConsoleHelper(scanner, dc);
        Skills skills = new Skills(1, "Kirill");
        SkillsRepository sr = new SkillsRepository();

        sr.writeSkillsFile(skills);
        System.out.println(sr.readSkillsFile());

//        view.run();

//        dr.readAccountFromFile()

        // TODO: 28.08.2018 Дописать классы и интерфейсы
    }
}
