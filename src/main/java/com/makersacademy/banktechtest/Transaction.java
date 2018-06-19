package com.makersacademy.banktechtest;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Transaction {

  private float amount;
  private float balance;
  private LocalDateTime date;

  public Transaction() {}

  public void buildTransaction(float amount, Account account) {
    this.amount = amount;
    this.balance = account.getBalance();
    this.date = setDate();
  }

  public float getAmount() { return this.amount; }

  public float getBalance() { return this.balance; }

  private LocalDateTime setDate() {
    return LocalDateTime.now();
  }

  public LocalDateTime getDate() { return this.date; }

}
