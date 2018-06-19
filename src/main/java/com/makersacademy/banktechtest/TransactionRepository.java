package com.makersacademy.banktechtest;

import java.util.ArrayList;
import javax.inject.Inject;

public class TransactionRepository {

  private ArrayList<Object> transactions;
  private Object transactionFactory;

  public TransactionRepository() {
    this.transactions = new ArrayList();
    this.transactionFactory = new TransactionFactory();
  }

  public TransactionRepository(Object factory) {
    this.transactions = new ArrayList();
    this.transactionFactory = factory;
  }

  public ArrayList<Object> getTransactions() {
    return transactions;
  }

  public void addTransaction(int amount, Account account) {
  }


}
