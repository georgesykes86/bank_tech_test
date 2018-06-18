package com.makersacademy.banktechtest;

import java.util.ArrayList;

public class TransactionRepository {

  private ArrayList<Transaction> transactions;

  public TransactionRepository() {
    this.transactions = new ArrayList<>();
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }

  public void addTransaction(int amount, Account account) {
    transactions.add(new Transaction());
  }

}
