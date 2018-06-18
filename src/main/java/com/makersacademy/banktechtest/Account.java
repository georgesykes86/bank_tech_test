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
    if (this.balance == 0) throw new ZeroBalanceException("Insufficient Funds");
    this.balance -= amount;
  }
}
