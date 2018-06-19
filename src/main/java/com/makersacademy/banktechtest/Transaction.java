package com.makersacademy.banktechtest;

import static java.lang.Math.abs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

  private float amount;
  private float balance;
  private String date;

  public Transaction() {}

  public void buildTransaction(float amount, Account account) {
    this.amount = amount;
    this.balance = account.getBalance();
    this.date = setDate();
  }

  public float getAmount() { return this.amount; }

  public float getBalance() { return this.balance; }

  private String setDate() {
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
    return dateFormat.format(date);
  }

  public String getDate() { return this.date; }

  public String toString() {
    if(this.amount < 0) {
      return this.getDate() + " || || " + floatToString(abs(this.amount))
          + " || " + floatToString(this.getBalance());
    }else {
      return this.getDate() + " || " + floatToString(this.amount)
          + " || || " + floatToString(this.getBalance());
    }
  }

  private String floatToString(float value) {
    return String.format("%.02f", value);
  }

}
