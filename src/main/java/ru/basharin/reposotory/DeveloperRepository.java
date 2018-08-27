package ru.basharin.reposotory;

import ru.basharin.model.Developer;

import java.io.*;

public class DeveloperRepository {

    public Object readDeveloperFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("developer.txt"))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeDeveloperInFile(Developer developer) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("developer.txt"))) {
                bufferedWriter.append((char) developer.getID())
                        .append(" ").append(developer.getName())
                        .append(" ").append((char) developer.getSkills().getId())
                        .append(" ").append((char) developer.getAccount().getId());
                bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
