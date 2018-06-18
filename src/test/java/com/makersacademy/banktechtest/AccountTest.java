package com.makersacademy.banktechtest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() {
    account = new Account();
  }

  @Test
  public void accountHasBalance() {
    assertEquals(0, account.getBalance());
  }

  @Test
  public void accountMakesDeposit() {
    account.deposit(100);
    assertEquals(100, account.getBalance());
  }
}
