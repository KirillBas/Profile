package ru.basharin.io;

import ru.basharin.model.Developer;

import java.io.*;

public class JavaIOAccountRepositoryImpl {

    public Object readDeveloperFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("account.txt"))) {
            return bufferedReader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeAccountInFile(Developer developer) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("account.txt"))) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
