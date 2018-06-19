package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.makersacademy.banktechtest.Statement;
import com.makersacademy.banktechtest.Transaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StatementTest {

  private Statement statement;
  private ArrayList<Transaction> transactions;
  private final String firstTestOutput = "date || credit || debit || balance\n"
     + "01/01/2000 || || 500.00 || 1500.00\n"
     + "01/02/2002 || 2000.00 || || 1000.00\n";

  private final String secondTestOutput = "date || credit || debit || balance\n"
     + "01/02/2002 || 2000.00 || || 1000.00\n"
     + "01/01/2000 || || 500.00 || 1500.00\n";

  private LocalDateTime date1;
  private LocalDateTime date2;

  @Mock
  Transaction transaction1 = new Transaction();

  @Mock
  Transaction transaction2 = new Transaction();

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    statement = new Statement();
    transactions = new ArrayList<>();
    date1 = LocalDateTime.of(2002, 2, 1, 0, 0, 0);
    date2 = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
    when(transaction1.getDate()).thenReturn(date1);
    when(transaction2.getDate()).thenReturn(date2);
    when(transaction1.getAmount()).thenReturn(2000f);
    when(transaction2.getAmount()).thenReturn(-500f);
    when(transaction1.getBalance()).thenReturn(1000f);
    when(transaction2.getBalance()).thenReturn(1500f);
  }

  @Test
  public void returnsStatementString() {
    transactions.add(transaction1);
    transactions.add(transaction2);
    statement.setTransactions(transactions);
    assertEquals(firstTestOutput, statement.toString());
  }

  @Test
  public void returnsDifferentStatementString() {
    transactions.add(transaction2);
    transactions.add(transaction1);
    statement.setTransactions(transactions);
    assertEquals(secondTestOutput, statement.toString());
  }


}
