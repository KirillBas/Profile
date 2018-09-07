package ru.basharin.view;

import ru.basharin.model.Account;
import ru.basharin.reposotory.io.JavaIOAccountRepositoryImpl;

import java.util.Scanner;

public class AccountView {
    private Scanner scanner;
    private JavaIOAccountRepositoryImpl javaIOAccountRepository = new JavaIOAccountRepositoryImpl();

    public void createAccount() {

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

        String ID;
        while (true) {
            System.out.println("Write ID");
            ID = scanner.nextLine();
            if (ID.equals("#")){
                return;
            }
            break;
        }

        Account account = new Account(Integer.parseInt(ID), login, pass);
        javaIOAccountRepository.create(account);
    }
}
