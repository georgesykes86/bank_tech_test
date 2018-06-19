package com.makersacademy.banktechtest;

import java.util.Date;

public class Transaction {

  private float amount;
  private float balance;
  private Date date;

  public Transaction() {}

  public void buildTransaction(float amount, Account account) {
    this.amount = amount;
    this.balance = account.getBalance();
    this.date = setDate();
  }

  public float getAmount() { return this.amount; }

  public float getBalance() { return this.balance; }

  private Date setDate() {
    return new Date();
  }

  public Date getDate() { return this.date; }

}
