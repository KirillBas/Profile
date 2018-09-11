package ru.basharin.reposotory.io;

import ru.basharin.model.Skill;
import ru.basharin.reposotory.SkillRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository{

    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\skills.txt";
    private File file = new File(FILE_NAME);

    @Override
    public void save(Skill skill) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(String.valueOf(skill));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill getByID(Long skillID) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] words = br.readLine().split(" ");
            for (int i = 0; i<words.length; i+=2) {
                if (Integer.parseInt(words[i]) == skillID) {
                    return new Skill(Integer.parseInt(words[i]), words[i+1]);
                } else {
                    System.out.println("Skill not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteByID(Long id) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        String line;
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            while ((line = bf.readLine()) != null) {
                String[] arrOfStr = line.split(" ");
                if (arrOfStr[0].equals(Long.toString(id))) {
                    continue;
                } else {
                    list.add(line);
                }
            }
            // write updated content without deleted item from ArrayList to file:
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
    public Long getByName(Skill skill) {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] result = line.split(" ");
                if (result[1].equals(skill.getName())) {
                    skill.setId(Integer.parseInt(result[0]));
                    return Long.parseLong(result[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1L;
    }

    @Override
    public List<Skill> readAll() {
        List<Skill> result = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                Skill skill = new Skill(0, null);
                String[] arrOfStr = line.split(" ");
                skill.setId(Integer.parseInt(arrOfStr[0]));
                skill.setName(arrOfStr[1]);
                result.add(skill);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
