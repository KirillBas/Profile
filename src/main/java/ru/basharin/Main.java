package ru.basharin;

import ru.basharin.view.ConsoleHelper;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ConsoleHelper consoleHelper = new ConsoleHelper(scanner);

        consoleHelper.run();
    }
}
