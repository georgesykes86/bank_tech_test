package com.makersacademy.banktechtest;

public class Transaction {

  private int amount;
  private int balance;

  public Transaction(int amount, Account account) {
    this.amount = amount;
    this.balance = account.getBalance();
  }

  public int getAmount() { return this.amount; }

  public int getBalance() { return this.balance; }

}
