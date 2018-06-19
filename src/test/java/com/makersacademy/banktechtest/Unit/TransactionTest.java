package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.makersacademy.banktechtest.Transaction;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionTest {

  private Transaction debitTransaction;
  private Transaction creditTransaction;
  private LocalDateTime date;

  @BeforeEach
  public void setUp() {
    debitTransaction = new Transaction();
    creditTransaction = new Transaction();
    debitTransaction.buildTransaction(-10.00f, 200f);
    creditTransaction.buildTransaction( 20.00f, 300f);
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
