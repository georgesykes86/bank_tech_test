package com.makersacademy.banktechtest;

import static java.lang.Math.abs;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Statement {

  private ArrayList<Transaction> transactions;

  public Statement() {}

  public void setTransactions(ArrayList<Transaction> transactions) {
    this.transactions = transactions;
  }

  public String toString() {
    return getStatementHeader() + formatTransactions(this.transactions);
  }

  private String getStatementHeader() {
    return "date || credit || debit || balance\n";
  }

  private String formatTransactions(ArrayList<Transaction> transactions) {
    String returnString = "";
    for (Transaction transaction: transactions) {
      returnString = transactionToString(transaction) + "\n" + returnString;
    }
    return returnString;
  }

  private String transactionToString(Transaction transaction) {
    String output = formatDate(transaction.getDate()) + " || ";
    if(transaction.getAmount() < 0) {
      output += "|| " + formatCurrencyAmount(abs(transaction.getAmount()));
    }else {
      output += formatCurrencyAmount(abs(transaction.getAmount())) + " ||";
    }
    return  output + " || " + formatCurrencyAmount(transaction.getBalance());
  }

  private String formatDate(LocalDateTime date) {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return date.format(dateFormat);
  }

  private String formatCurrencyAmount(float value) {
    return String.format("%.02f", value);
  }

}



