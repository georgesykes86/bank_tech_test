package com.makersacademy.banktechtest;

import java.util.ArrayList;

public class TransactionRepository {

  private ArrayList<Transaction> transactions;
  private TransactionFactory transactionFactory;

  public TransactionRepository(TransactionFactory transactionFactory) {
    this.transactions = new ArrayList();
    this.transactionFactory = transactionFactory;
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }

  public void addTransaction(int amount, Account account) {
    transactions.add(createTransaction(amount, account));
  }

  private Transaction createTransaction(int amount, Account account) {
    Transaction transaction = this.transactionFactory.getTransaction();
    transaction.buildTransaction(amount, account);
    return transaction;
  }

  public String printTransactions() {
    String returnString = "";
    for (Transaction transaction: transactions) {
      returnString += transaction.toString() + "\n";
    }
    return returnString;
  }

}
