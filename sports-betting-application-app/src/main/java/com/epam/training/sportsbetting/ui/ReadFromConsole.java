package com.epam.training.sportsbetting.ui;

import static com.epam.training.sportsbetting.service.SportBettingService.stringToDate;

import java.util.Scanner;

import com.epam.training.sportsbetting.domain.user.Currency;
import com.epam.training.sportsbetting.domain.user.Player;

public class ReadFromConsole {

    public static Scanner sc = new Scanner(System.in);

    public static void readPlayerDataFromConsole(Player player) {

        readName(player);
        readAccountNumber(player);
        readBalance(player);
        readCurrency(player);
        readDateOfBirth(player);

    }

    private static void readDateOfBirth(Player player) {
        String enteredData = null;
        boolean dataIsValid = false;
        do {
            System.out.println(" When were you born? eg.:1990-02-03");
            try {
                if (!(enteredData = readOneLine()).equals("")) {
                    player.setBirthDate(stringToDate(enteredData));
                    dataIsValid = true;
                }
            } catch (Exception e) {
                System.out.println(enteredData + " is not a valid date");
            }
        } while (!dataIsValid);

    }

    private static void readCurrency(Player player) {
        boolean dataIsValid = false;
        String enteredData;
        do {
            System.out.println(" What is your currency? (HUF, EUR or USD)");
            switch (enteredData = readOneLine().toUpperCase()) {
            case "HUF":
                player.currency = Currency.HUF;
                dataIsValid = true;
                break;
            case "EUR":
                player.currency = Currency.EUR;
                dataIsValid = true;
                break;
            case "USD":
                player.currency = Currency.USD;
                dataIsValid = true;
                break;
            default:
                System.out.println("not a valid currency: " + enteredData);
            }

        } while (!dataIsValid);
    }

    private static void readBalance(Player player) {
        String enteredData;
        boolean dataIsValid = false;
        do {
            System.out.println("How much money do you have? (more than 0)");
            try {
                if (!(enteredData = readOneLine()).equals("")) {
                    player.setBalance(Long.parseLong(enteredData));
                    dataIsValid = true;
                }
            } catch (NumberFormatException e1) {
                System.out.println("Invalid amount");
            }
        } while (!dataIsValid);
    }

    private static void readAccountNumber(Player player) {
        String enteredData;
        System.out.println("What is your account number?");
        if (!(enteredData = readOneLine()).equals("")) {
            player.setAccountNumber(enteredData);
        }
    }

    private static void readName(Player player) {
        String enteredData;
        System.out.println("What is your name?");
        if (!(enteredData = readOneLine()).equals("")) {
            player.setName(enteredData);
        }
    }

    public static String readOneLine() {
        String readLine = sc.nextLine();
        return readLine;
    }

    public static double readAmount(Player player) {
        double choosedAmount = 0;
        boolean amountIsValid;
        do {
            System.out.println("How much do you want to bet on it? (q for quit)");
            amountIsValid = false;
            String amount = readOneLine();
            if (amount.equals("q")) { //
                return 0;
            }
            try {
                choosedAmount = Double.parseDouble(amount);
                if (choosedAmount <= player.getBalance()) {
                    amountIsValid = true;
                } else {
                    System.out.println("You don't have enough money, your balance is " + player.getBalance() + player.currency);
                }
            } catch (NumberFormatException e) {
                System.out.println("not a valid amount");
            }
        } while (!amountIsValid);
        return choosedAmount;
    }

}
