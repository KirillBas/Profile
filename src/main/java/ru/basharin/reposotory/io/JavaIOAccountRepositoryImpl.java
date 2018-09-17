package ru.basharin.reposotory.io;

import ru.basharin.model.Account;
import ru.basharin.reposotory.AccountRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\accounts.txt";
    private final File file = new File(FILE_NAME);



    @Override
    public void save(Account account) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(String.valueOf(account));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getByID(Long accountId) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                if (words[0].equals(accountId)) {
                    return new Account(Integer.parseInt(words[0]), words[1], words[2]);
                } else {
                    System.out.println("Account not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteByID(Long accountId) {
        List<String> list = new ArrayList<>();
        String line;
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            while ((line = bf.readLine()) != null) {
                String[] arrOfStr = line.split(" ");
                if (arrOfStr[0].equals(Long.toString(accountId))) {
                    continue;
                } else {
                    list.add(line);
                }
            }
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
    public List<Account> readAll() {
        List<Account> accountList = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] result = line.split(" ");
                Account account = new Account(0, null, null);
                account.setId(Integer.parseInt(result[0]));
                account.setName(result[1]);
                account.setPassword(result[2]);
                accountList.add(account);
            }
            return accountList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getByName(Account account) {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                if (words[1].equals(account.getName())) {
                    return Long.parseLong(words[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
