package com.makersacademy.banktechtest;

public class TransactionFactory {

  public static Transaction getTransaction(int amount, Account account) {
    return new Transaction(amount, account);
  }

}
