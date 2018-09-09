package ru.basharin.reposotory.io;

import ru.basharin.model.Developer;
import ru.basharin.reposotory.DeveloperRepository;

import java.io.*;
import java.util.*;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository{

    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\developer.txt";
    private List<Developer> developerList = new ArrayList<>();

    private void readDeveloperFile() {
        try (Scanner scanner = new Scanner(new FileReader(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                Developer dev = new Developer(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]),Integer.parseInt(words[3]));
                developerList.add(dev);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDeveloperInFile(List<Developer> developerList) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Developer developer: developerList) {
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

    @Override
    public void save(Developer developer) {
        writeDeveloperInFile(developerList);
    }

    @Override
    public Developer getByID(Long developerId) {
        for (Developer result: developerList) {
            if (developerId.equals(result.getID())) {
                return result;
            }
        }
        return null;
    }

    @Override
    public void deleteByID(Long developerId) {
        for (Developer result: developerList) {
            if (developerId.equals(result.getID())) {
                developerList.remove(result);
            }
        }
    }

    @Override
    public List<Developer> readAll() {
        readDeveloperFile();
        return developerList;
    }

    @Override
    public Long getByName(Developer developer) {
        return null;
    }
}
