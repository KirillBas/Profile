package ru.basharin.reposotory.io;

import ru.basharin.model.Skills;
import ru.basharin.reposotory.SkillRepository;

import java.io.*;
import java.util.*;

public class JavaIOSkillRepositoryImpl implements SkillRepository{

    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\skills.txt";
    private File file = new File(FILE_NAME);

// TODO: 02.09.2018 Проблемма при чтении файла первого значения если мы пытаемся вернуть Skills.
// TODO: 02.09.2018  Вероятно потому что при записи автоматически добавляется какойто знак к значению ID.
// TODO: 02.09.2018 при возвращении Object все корректно читается. Задать вопрос Жене
    private Object readSkillsFile() {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeSkillsInFile(Skills skills) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(skills.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Skills skills) {
        writeSkillsInFile(skills);
    }

    public Object read() {
        return readSkillsFile();
    }

//    @Override
//    public Skills getByID(Long skillID) {
//        for (Skills result: skillsList) {
//            if (skillID.equals(result.getId())) {
//                return result;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteByID(Long skillID) {
//        for (Skills result: skillsList) {
//            if (skillID.equals(result.getId())) {
//                skillsList.remove(result);
//            }
//        }
//    }
//
//    @Override
//    public List<Skills> readAll() {
//        readSkillsFile();
//        return skillsList;
//    }
}
