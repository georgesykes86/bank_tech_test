package com.makersacademy.banktechtest;

import com.makersacademy.banktechtest.Exceptions.InvalidTransactionAmountException;
import com.makersacademy.banktechtest.Exceptions.ZeroBalanceException;

public class Account {

  private float balance;
  private TransactionRepository repository;
  private Printer printer;
  private Statement statement;

  public Account(TransactionRepository repository, Printer printer, Statement statement) {
    this.repository = repository;
    this.printer = printer;
    this.statement = statement;
  }

  public float getBalance() {
    return this.balance;
  }

  public void deposit(float amount) throws InvalidTransactionAmountException {
    if(amount <= 0 ) throw new InvalidTransactionAmountException("Amount must be greater than Zero");
    this.balance += amount;
    this.repository.addTransaction(amount, this);
  }

  public void withdraw(float amount) throws ZeroBalanceException,
      InvalidTransactionAmountException {
    if(amount <= 0 ) throw new InvalidTransactionAmountException("Amount must be greater than Zero");
    if((this.balance - amount) < 0) throw new ZeroBalanceException("Insufficient Funds");
    this.balance -= amount;
    this.repository.addTransaction((-amount), this);
  }

  public void printStatement() {
    createStatement();
    printer.print(statement.toString());
  }

  private void createStatement() {
    statement.setTransactions(repository.getTransactions());
  }

}
