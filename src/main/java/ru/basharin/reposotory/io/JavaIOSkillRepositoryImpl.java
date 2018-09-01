package ru.basharin.reposotory.io;

import ru.basharin.model.Skills;
import ru.basharin.reposotory.SkillRepository;

import java.io.*;
import java.util.*;

public class JavaIOSkillRepositoryImpl implements SkillRepository{

    private final String FILE_NAME = "skills.txt";
    private List<Skills> skillsList = new ArrayList<>();

    public JavaIOSkillRepositoryImpl(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    private void readSkillsFile() {

        try (Scanner scanner = new Scanner(new FileReader(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                Skills skills = new Skills(Integer.parseInt(words[0]), words[1], words[2], words[3], words[0], words[1], words[2], words[3]);
                skillsList.add(skills);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeSkillsInFile(List<Skills> skillsList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Skills newSkill : skillsList)
                bufferedWriter.append(String.valueOf(newSkill.getId()))
                        .append(" ").append(newSkill.getJava())
                        .append(" ").append(newSkill.getSQL())
                        .append(" ").append(newSkill.getSpring())
                        .append(" ").append(newSkill.getMaven())
                        .append(" ").append(newSkill.getHibernate())
                        .append(" ").append(newSkill.getJDBC())
                        .append(" ").append(newSkill.getGit());
                bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Skills skills) {
        skillsList.add(skills);
        writeSkillsInFile(skillsList);
    }

    @Override
    public Skills getByID(Long skillID) {
        for (Skills result: skillsList) {
            if (skillID.equals(result.getId())) {
                return result;
            }
        }
        return null;
    }

    @Override
    public void deleteByID(Long skillID) {
        for (Skills result: skillsList) {
            if (skillID.equals(result.getId())) {
                skillsList.remove(result);
            }
        }
    }

    @Override
    public List<Skills> readAll() {
        readSkillsFile();
        return skillsList;
    }
}
