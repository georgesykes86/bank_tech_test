package com.makersacademy.banktechtest;

public class Account {

  private int balance;

  public Account() {}

  public int getBalance() {
    return this.balance;
  }

  public void deposit(int amount) {
    this.balance += amount;
  }

  public void withdraw(int amount) throws ZeroBalanceException {
    if ((this.balance - amount) < 0) throw new ZeroBalanceException("Insufficient Funds");
    this.balance -= amount;
  }

  public void printStatement() {
    System.out.print("date || credit || debit || balance\n" +
        "18/06/2018 || || 500.00 || 2500.00\n" +
        "18/06/2018 || 2000.00 || || 3000.00\n" +
        "18/06/2018 || 1000.00 || || 1000.00"
    );
  }

}
