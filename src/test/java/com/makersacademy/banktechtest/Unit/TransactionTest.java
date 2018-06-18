package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TransactionTest {

  private Transaction debitTransaction;
  private Transaction creditTransaction;

  @Mock
  private Account account;

  @BeforeEach
  public void setUp() {
    debitTransaction = new Transaction(-10, account);
    creditTransaction = new Transaction(20, account);
  }

  @Test
  public void setsTheAmount(){
    assertEquals(20, creditTransaction.getAmount());
  }

  @Test
  public void setsAnotherAmount() { assertEquals(-10, debitTransaction.getAmount()); }

}
