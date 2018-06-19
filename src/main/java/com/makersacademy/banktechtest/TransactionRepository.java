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

  public void addTransaction(float amount, float balance) {
    transactions.add(createTransaction(amount, balance));
  }

  private Transaction createTransaction(float amount, float balance) {
    Transaction transaction = this.transactionFactory.getTransaction();
    transaction.buildTransaction(amount, balance);
    return transaction;
  }

}
