package ru.basharin;

import ru.basharin.controller.DeveloperController;
import ru.basharin.reposotory.DeveloperRepository;
import ru.basharin.view.View;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DeveloperRepository dr = new DeveloperRepository();
        DeveloperController dc = new DeveloperController(scanner, dr);
        View view = new View(scanner, dc);

//        view.run();

//        dr.readAccountFromFile();
        System.out.println(dr.readDeveloperFile());
        // TODO: 28.08.2018 Дописать классы и интерфейсы
    }
}
