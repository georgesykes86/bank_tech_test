package com.makersacademy.banktechtest;

public class Account {

  private int balance;
  private TransactionRepository repository;
  private Printer printer;

  public Account(TransactionRepository repository, Printer printer) {
    this.repository = repository;
    this.printer = printer;
  }

  public int getBalance() {
    return this.balance;
  }

  public void deposit(int amount) {
    this.balance += amount;
  }

  public void withdraw(int amount) throws ZeroBalanceException {
    if ((this.balance - amount) < 0) throw new ZeroBalanceException("Insufficient Funds");
    this.balance -= amount;
  }

  public void printStatement() {
    printer.print(
        getStatementHeader() + "\n" + repository.printTransactions()
    );
  }

  private String getStatementHeader() {
    return "date || credit || debit || balance";
  }
}
