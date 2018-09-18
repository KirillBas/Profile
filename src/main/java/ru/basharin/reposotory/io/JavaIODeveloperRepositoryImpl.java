package ru.basharin.reposotory.io;

import ru.basharin.model.Developer;
import ru.basharin.reposotory.DeveloperRepository;

import java.io.*;
import java.util.*;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository{

    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\developer.txt";
    private File file = new File(FILE_NAME);

    @Override
    public void save(Developer developer) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(String.valueOf(developer));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer getByID(Long developerId) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                if (words[0].equals(developerId)) {
                    return new Developer(Integer.parseInt(words[0]), words[1], Long.parseLong(words[2]), Long.parseLong(words[3]));
                } else {
                    System.out.println("Account not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteByID(Long developerId) {
        List<String> list = new ArrayList<>();
        String line;
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            while ((line = bf.readLine()) != null) {
                String[] arrOfStr = line.split(" ");
                if (arrOfStr[0].equals(Long.toString(developerId))) {
                    continue;
                } else {
                    list.add(line);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
                for (String str : list) {
                    bw.write(str + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Developer> readAll() {
        List<Developer> developerList = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] result = line.split(" ");
                Developer developer = new Developer(0, null, 0,0);
                developer.setId(Integer.parseInt(result[0]));
                developer.setName(result[1]);
                developer.setSkillsID(Long.parseLong(result[2]));
                developer.setAccountID(Long.parseLong(result[3]));
                developerList.add(developer);
            }
            return developerList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getByName(Developer developer) {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                if (words[1].equals(developer.getName())) {
                    return Long.parseLong(words[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
