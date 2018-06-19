package com.makersacademy.banktechtest;

import com.makersacademy.banktechtest.Exceptions.InvalidTransactionAmountException;
import com.makersacademy.banktechtest.Exceptions.ZeroBalanceException;

public class BankRunner {

  public static void main(String[] args) throws ZeroBalanceException,
      InvalidTransactionAmountException {
    runApp();
  }

  private static void runApp() throws ZeroBalanceException, InvalidTransactionAmountException {
    TransactionRepository repository = new TransactionRepository(new TransactionFactory());
    Account account = new Account(repository, new Printer(), new Statement(), new TransactionValidator());
    account.deposit(1000);
    account.deposit(2000);
    account.withdraw(500);
    account.withdraw(505.50f);
    account.deposit(50);
    account.printStatement();
  }

}
