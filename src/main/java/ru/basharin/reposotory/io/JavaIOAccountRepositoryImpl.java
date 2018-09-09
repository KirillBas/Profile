package ru.basharin.reposotory.io;

import ru.basharin.model.Account;
import ru.basharin.reposotory.AccountRepository;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\accounts.txt";
    private List<Account> accountList = new ArrayList<>();

    private void readAccountFile() {
        try (Scanner scanner = new Scanner(new FileReader(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                Account account = new Account(Integer.parseInt(words[0]), words[1], words[2]);
                accountList.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAccountInFile(List<Account> accountList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account account : accountList) {
                bufferedWriter.append((char) account.getId())
                        .append(" ").append(account.getAccountName())
                        .append(" ").append(account.getPassword());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create(Account account) {
        accountList.add(account);
    }

    @Override
    public void save(Account account) {
        writeAccountInFile(accountList);
    }

    @Override
    public Account getByID(Long accountId) {
        for (Account result : accountList) {
            if (accountId.equals(result.getId())) {
                return result;
            }
        }
        return null;
    }

    @Override
    public void deleteByID(Long accountId) {
        for (Account result : accountList) {
            if (accountId.equals(result.getId())) {
                accountList.remove(result);
            }
        }
    }

    @Override
    public List<Account> readAll() {
        readAccountFile();
        return accountList;
    }

    @Override
    public Long getByName(Account account) {
        return null;
    }
}
