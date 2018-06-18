package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TransactionTest {

  private Transaction transaction;

  @Mock
  private Account account;

  @BeforeEach
  public void setUp() {
    transaction = new Transaction(10, account);
  }

  @Test
  public void setsTheAmount(){
    assertEquals(10, transaction.getAmount());
  }

}
