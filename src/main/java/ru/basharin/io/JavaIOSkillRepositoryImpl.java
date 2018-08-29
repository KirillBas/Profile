package ru.basharin.io;

import ru.basharin.model.Skills;

import java.io.*;

public class JavaIOSkillRepositoryImpl {

    public Object readSkillsFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("skills.txt"))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeSkillsFile(Skills skills) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("skills.txt"))) {
            bufferedWriter.append(String.valueOf(skills.getId()))
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
}
