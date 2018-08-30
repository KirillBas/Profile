package ru.basharin.io;

import ru.basharin.model.Developer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaIODeveloperRepositoryImpl {

    public Map<Long,Developer> readDeveloperFile() {
        Map<Long, Developer> result = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader("developer.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                Developer dev = new Developer(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]),Integer.parseInt(words[3]));
                result.put(dev.getID(), dev);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeDeveloperInFile(Map<Long,Developer> dev) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("developer.txt"))) {
            for (Long id : dev.keySet()) {
                Developer developer = dev.get(id);
                bufferedWriter.append((char) developer.getID())
                        .append(" ").append(developer.getName())
                        .append(" ").append(String.valueOf(developer.getSkillsID()))
                        .append(" ").append(String.valueOf(developer.getAccountID()));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
