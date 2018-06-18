package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TransactionTest {

  private Transaction debitTransaction;
  private Transaction creditTransaction;

  @Mock
  private Account firstAccount;

  @Mock
  private Account secondAccount;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(firstAccount.getBalance()).thenReturn(200);
    when(secondAccount.getBalance()).thenReturn(300);
    debitTransaction = new Transaction(-10, firstAccount);
    creditTransaction = new Transaction(20, secondAccount);
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

}
