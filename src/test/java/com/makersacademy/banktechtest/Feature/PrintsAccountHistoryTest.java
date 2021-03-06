package com.makersacademy.banktechtest.Feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.makersacademy.banktechtest.*;
import com.makersacademy.banktechtest.Exceptions.InvalidTransactionAmountException;
import com.makersacademy.banktechtest.Exceptions.ZeroBalanceException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrintsAccountHistoryTest {

  private final ByteArrayOutputStream output = new ByteArrayOutputStream();
  private Account account;
  private Date date = new Date();
  private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
  private String dateFormatted;
  private String firstTestOutput = null;
  private String secondTestOutput = null;
  private String longStatement = null;

  @BeforeEach
  public void setUp() {
    account = new Account(new TransactionRepository(new TransactionFactory()),
        new Printer(), new Statement(), new TransactionValidator());
    System.setOut(new PrintStream(output));
    date =  new Date();
    dateFormatted = dateFormat.format(date);

    firstTestOutput = "date || credit || debit || balance\n"
        + dateFormatted + " || || 500.00 || 2500.00\n"
        + dateFormatted + " || 2000.00 || || 3000.00\n"
        + dateFormatted + " || 1000.00 || || 1000.00\n";

    secondTestOutput = "date || credit || debit || balance\n"
        + dateFormatted + " || || 1500.00 || 3500.00\n"
        + dateFormatted + " || 3000.00 || || 5000.00\n"
        + dateFormatted + " || 2000.00 || || 2000.00\n";

    longStatement = "date || credit || debit || balance\n"
        + dateFormatted + " || || 500.00 || 6000.00\n"
        + dateFormatted + " || 2000.00 || || 6500.00\n"
        + dateFormatted + " || 1000.00 || || 4500.00\n"
        + dateFormatted + " || || 1500.00 || 3500.00\n"
        + dateFormatted + " || 3000.00 || || 5000.00\n"
        + dateFormatted + " || 2000.00 || || 2000.00\n";
  }

  @Test
  public void printsAnAccountHistory() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.deposit(1000);
    account.deposit(2000);
    account.withdraw(500);
    account.printStatement();
    assertEquals(firstTestOutput, output.toString());
  }

  @Test
  public void printsAnotherAccountHistory() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.deposit(2000);
    account.deposit(3000);
    account.withdraw(1500);
    account.printStatement();
    assertEquals(secondTestOutput, output.toString());
  }

  @Test
  public void printsDifferentStatementsAfterExtraTransactions() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.deposit(2000);
    account.deposit(3000);
    account.withdraw(1500);
    account.printStatement();
    assertEquals(secondTestOutput, output.toString());
    account.deposit(1000);
    account.deposit(2000);
    account.withdraw(500);
    account.printStatement();
    assertEquals(secondTestOutput + longStatement, output.toString());
  }

}
