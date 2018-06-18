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

  public void withdraw(int amount) { this.balance -= amount; }
}
