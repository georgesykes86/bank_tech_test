package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.Transaction;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TransactionTest {

  private Transaction debitTransaction;
  private Transaction creditTransaction;
  private LocalDateTime date;

  @Mock
  private Account firstAccount;

  @Mock
  private Account secondAccount;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(firstAccount.getBalance()).thenReturn(200.00f);
    when(secondAccount.getBalance()).thenReturn(300.00f);
    debitTransaction = new Transaction();
    creditTransaction = new Transaction();
    debitTransaction.buildTransaction(-10.00f, firstAccount);
    creditTransaction.buildTransaction( 20.00f, secondAccount);
    date = LocalDateTime.now();
  }

  @Test
  public void setsTheAmount(){
    assertEquals(20, creditTransaction.getAmount());
  }

  @Test
  public void setsAnotherAmount() { assertEquals(-10, debitTransaction.getAmount()); }

  @Test
  public void setsTheBalance() {
    assertEquals(200, debitTransaction.getBalance());
  }

  @Test
  public void setsDifferentBalance() {
    assertEquals(300, creditTransaction.getBalance());
  }

  @Test
  public void setsDate() {
    assertEquals(date.toLocalDate(), creditTransaction.getDate().toLocalDate());
  }

}
