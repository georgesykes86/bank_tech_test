package com.makersacademy.banktechtest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

  private int amount;
  private int balance;
  private String date;

  public Transaction() {}

  public void buildTransaction(int amount, Account account) {
    this.amount = amount;
    this.balance = account.getBalance();
    this.date = setDate();
  }

  public int getAmount() { return this.amount; }

  public int getBalance() { return this.balance; }

  private String setDate() {
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
    return dateFormat.format(date);
  }

  public String getDate() { return this.date; }

}
