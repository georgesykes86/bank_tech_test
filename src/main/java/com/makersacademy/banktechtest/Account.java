package com.makersacademy.banktechtest;

import com.makersacademy.banktechtest.Exceptions.InvalidTransactionAmountException;
import com.makersacademy.banktechtest.Exceptions.ZeroBalanceException;

public class Account {

  private float balance;
  private TransactionRepository repository;
  private Printer printer;
  private Statement statement;
  private TransactionValidator validator;

  public Account(TransactionRepository repository, Printer printer,
      Statement statement, TransactionValidator validator) {
    this.repository = repository;
    this.printer = printer;
    this.statement = statement;
    this.validator = validator;
  }

  public float getBalance() {
    return this.balance;
  }

  public void deposit(float amount) throws InvalidTransactionAmountException {
    validator.validateTransaction(amount);
    this.balance += amount;
    this.repository.addTransaction(amount, this.getBalance());
  }

  public void withdraw(float amount) throws ZeroBalanceException,
      InvalidTransactionAmountException {
    validator.validateTransaction(amount);
    if((this.balance - amount) < 0) throw new ZeroBalanceException("Insufficient Funds");
    this.balance -= amount;
    this.repository.addTransaction((-amount), this.getBalance());
  }

  public void printStatement() {
    createStatement();
    printer.print(statement.toString());
  }

  private void createStatement() {
    statement.setTransactions(repository.getTransactions());
  }

}
