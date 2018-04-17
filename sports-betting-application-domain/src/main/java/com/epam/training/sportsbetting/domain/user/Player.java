package com.epam.training.sportsbetting.domain.user;

import java.time.LocalDate;

public class Player {

    private String name;
    private String accountNumber;
    private double balance;
    public Currency currency;
    private LocalDate birthDate;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double d) {
        balance = d;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
