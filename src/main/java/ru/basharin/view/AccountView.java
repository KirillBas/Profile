package ru.basharin.view;

import ru.basharin.controller.AccountController;
import ru.basharin.model.Account;
import ru.basharin.reposotory.io.JavaIOAccountRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    private Scanner scanner = new Scanner(System.in);
    private AccountController accountController = new AccountController();
    private int numberID = 0;

    public void createAccount() {


        Account account = new Account(0, null, null);

        String login;
        while (true) {
            System.out.println("Write login");
            login = scanner.nextLine();
            if (login.equals("#")) {
                return;
            }
            break;
            // TODO: 18.08.2018 написать валидацию логина
        }

        String pass;
        while (true) {
            System.out.println("Write password");
            pass = scanner.nextLine();
            if (pass.equals("#")) {
                return;
            }
            break;
        }
        account.setId(++numberID);
        account.setName(login);
        account.setPassword(pass);
        accountController.save(account);
    }

    public void deleteAccount() {
        Account account = new Account(0,null, null);
        String input;
        while (true) {
            System.out.println("Write account for delete");
            input = scanner.nextLine();
            if (input.equals("#")) {
                return;
            } else {
                account.setName(input);
                long id = accountController.readAccount(account);
                accountController.deleteAccount(id);
            }
        }
    }

    public List<Account> readAll() {
        System.out.println("List accounts");
        return accountController.readAll();
    }

    void accountMenu() {
        String input;
        while (true) {
            System.out.println("Select menu item");
            System.out.println("Create account: #1");
            System.out.println("Delete account: #2");
            System.out.println("Read all accounts: #3");
            System.out.println("Return: #");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    deleteAccount();
                    break;
                case "3":
                    System.out.println(readAll());
                    break;
                case "#":
                    return;
            }
        }
    }
}
