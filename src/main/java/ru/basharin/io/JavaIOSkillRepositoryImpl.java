package ru.basharin.io;

import ru.basharin.model.Skills;

import java.io.*;
import java.util.*;

public class JavaIOSkillRepositoryImpl {

    public Map<Long, Skills> readSkillsFile() {
        Map<Long, Skills> result = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader("skills.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                Skills skills = new Skills(Integer.parseInt(words[0]), words[1], words[2], words[3], words[0], words[1], words[2], words[3]);
                result.put(skills.getId(), skills);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeSkillsInFile(Map<Long, Skills> skills) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("skills.txt"))) {
            for (Long id : skills.keySet()) {
                Skills skill = skills.get(id);
                bufferedWriter.append(String.valueOf(skill.getId()))
                        .append(" ").append(skill.getJava())
                        .append(" ").append(skill.getSQL())
                        .append(" ").append(skill.getSpring())
                        .append(" ").append(skill.getMaven())
                        .append(" ").append(skill.getHibernate())
                        .append(" ").append(skill.getJDBC())
                        .append(" ").append(skill.getGit());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
