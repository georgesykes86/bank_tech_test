package com.makersacademy.banktechtest;

public class Account {

  private float balance;
  private TransactionRepository repository;
  private Printer printer;

  public Account(TransactionRepository repository, Printer printer) {
    this.repository = repository;
    this.printer = printer;
  }

  public float getBalance() {
    return this.balance;
  }

  public void deposit(float amount) {
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
    printer.print(
        getStatementHeader() + "\n" + repository.printTransactions()
    );
  }

  private String getStatementHeader() {
    return "date || credit || debit || balance";
  }

}
