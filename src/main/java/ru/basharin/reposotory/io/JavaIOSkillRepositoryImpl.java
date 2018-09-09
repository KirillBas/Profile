package ru.basharin.reposotory.io;

import ru.basharin.model.Skill;
import ru.basharin.reposotory.SkillRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaIOSkillRepositoryImpl implements SkillRepository{

    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\skills.txt";
    private File file = new File(FILE_NAME);

    @Override
    public void save(Skill skill) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(String.valueOf(skill));
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
    public void deleteByID(Long skillID) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] words = br.readLine().split(" ");
            for (int i = 0; i<words.length; i+=2) {
                if (Long.parseLong(words[i]) == skillID) {
                    words[i] = null;
                    words[i+1] = null;
                    // TODO: 09.09.2018 здесь нужно организовать запись исправленных данных, но нельзя просто передать массив
//                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
//                        bw.write();
//                    }
                    return;
                } else {
                    System.out.println("Skill not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Skill> readAll() {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<Skill> result = new ArrayList<>();
            String[] words = br.readLine().split(" ");
            for (int i = 0; i<words.length; i+=2) {
                Skill skill = new Skill(Integer.parseInt(words[i]), words[i+1]);
                result.add(skill);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getByName(Skill skill) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] words = br.readLine().split(" ");
            for (int i = 1; i<words.length; i+=2) {
                if (words[i].equals(skill.getName())) {
                    return Long.parseLong(words[i-1]);
                } else {
                    System.out.println("Skill not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1L;
    }
}
