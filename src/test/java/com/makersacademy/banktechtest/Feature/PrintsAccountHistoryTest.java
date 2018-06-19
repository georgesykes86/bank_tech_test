package com.makersacademy.banktechtest.Feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.Printer;
import com.makersacademy.banktechtest.TransactionFactory;
import com.makersacademy.banktechtest.TransactionRepository;
import com.makersacademy.banktechtest.ZeroBalanceException;
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

  @BeforeEach
  public void setUp() {
    account = new Account(new TransactionRepository(new TransactionFactory()), new Printer());
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
  }

  @Test
  public void printsAnAccountHistory() throws ZeroBalanceException {
    account.deposit(1000);
    account.deposit(2000);
    account.withdraw(500);
    account.printStatement();
    assertEquals(firstTestOutput, output.toString());
  }

  @Test
  public void printsAnotherAccountHistory() throws ZeroBalanceException {
    account.deposit(2000);
    account.deposit(3000);
    account.withdraw(1500);
    account.printStatement();
    assertEquals(secondTestOutput, output.toString());
  }

}
