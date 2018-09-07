package ru.basharin.reposotory.io;

import ru.basharin.model.Skills;
import ru.basharin.reposotory.SkillRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository{

    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\skills.txt";
    private File file = new File(FILE_NAME);

    private List<Skills> readSkillsFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<Skills> result = new ArrayList<>();
            String[] words = br.readLine().split(" ");
            Skills skills = new Skills(Integer.parseInt(words[0]), words[1]);
            result.add(skills);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeListSkills(List<Skills> skillsList) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(String.valueOf(skillsList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeSkillsInFile(Skills skills) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(String.valueOf(skills));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Skills skills) {
        writeSkillsInFile(skills);
    }

    @Override
    public Skills getByID(Long skillID) {
        List<Skills> readSkills = readAll();
        for (Skills result: readSkills) {
            if (skillID.equals(result.getId())) {
                return result;
            }
        }
        return null;
    }

    @Override
    public void deleteByID(Long skillID) {
        List<Skills> readSkills = readAll();
        for (Skills result: readSkills) {
            if (skillID.equals(result.getId())) {
                readSkills.remove(result);
                writeListSkills(readSkills);
            } else {
                System.out.println("Skill not found");
            }
        }
    }

    @Override
    public List<Skills> readAll() {
        return readSkillsFile();
    }
}
