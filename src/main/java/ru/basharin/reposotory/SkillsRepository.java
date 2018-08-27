package ru.basharin.reposotory;

import ru.basharin.model.Skills;

import java.io.*;

public class SkillsRepository implements SkillRepository {

    public Object readSkillsFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("skills.txt"))) {
            return bufferedReader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeSkillsFile(Skills skills) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("skills.txt"))) {
            bufferedWriter.append((char) skills.getId())
                    .append(" ").append(skills.getJava())
                    .append(" ").append(skills.getSQL())
                    .append(" ").append(skills.getSpring())
                    .append(" ").append(skills.getMaven())
                    .append(" ").append(skills.getHibernate())
                    .append(" ").append(skills.getJDBC())
                    .append(" ").append(skills.getGit());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: 28.08.2018 Дописать методы
    @Override
    public void save(Skills skills) {
        writeSkillsFile(skills);
    }

    @Override
    public Skills getByID(Long aLong) {
        return null;
    }

    @Override
    public void deleteByID(Long aLong) {

    }

    @Override
    public void create(Skills skills) {

    }
}
