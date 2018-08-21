package ru.basharin.reposotory;

import ru.basharin.model.Account;
import ru.basharin.model.Developer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository {

    private final Path pathDeveloper = Paths.get("developer.txt");
    private final Path pathSkills = Paths.get("skills.txt");
    private final Path pathAccounts = Paths.get("accounts.txt");
    private final List<Account> accountList = new ArrayList<>();

    public void checkFile() throws IOException {
        if (!Files.exists(pathDeveloper)) {
            System.out.println("File developer.txt is not found");
            Files.createFile(pathDeveloper);
            System.out.println("File developer.txt is create");
        }

        if (!Files.exists(pathSkills)) {
            System.out.println("File skills.txt is not found");
            Files.createFile(pathSkills);
            System.out.println("File skills.txt is create");
        }

        if (!Files.exists(pathAccounts)) {
            System.out.println("File accounts.txt is not found");
            Files.createFile(pathAccounts);
            System.out.println("File accounts.txt is create");
        }
    }

    public void readAccountFromFile() {

//        try (FileChannel fChannel = (FileChannel) Files.newByteChannel(pathAccounts)) {
//            long fileSze = fChannel.size();
//            MappedByteBuffer mappedByteBuffer = fChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSze);
//            CharBuffer charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
//
//            return charBuffer;
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        return null;

        try(BufferedReader ois = new BufferedReader(new FileReader("accounts.txt"))) {
            ois.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAccountInFile(List<Account> accounts) {
//        CharBuffer charBuffer = CharBuffer.wrap(accounts.toString());
//        try (FileChannel fChannel = (FileChannel)
//                Files.newByteChannel(pathAccounts,
//                        StandardOpenOption.READ,
//                        StandardOpenOption.WRITE,
//                        StandardOpenOption.CREATE)) {
//            long j = charBuffer.length();
//            MappedByteBuffer mBuf = fChannel.map(FileChannel.MapMode.READ_WRITE, 0, j);
//            mBuf.put(Charset.forName("utf-8").encode(charBuffer));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("accounts.txt"))) {
            for (Account acc :
                    accounts) {

                bufferedWriter.append(acc.getAccountName())
                        .append(" ")
                        .append(acc.getPassword());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDeveloperInFile(Developer developer) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("developer.txt"))) {
                bufferedWriter.append((char) developer.getID())
                        .append(" ").append(developer.getName())
                        .append(" ").append(developer.getSkillsSet().toString())
                        .append(" ").append(developer.getAccount().toString());
                bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
