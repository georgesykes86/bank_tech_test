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

  @Test
  public void accountMakesSecondDeposit() {
    account.deposit(50);
    account.deposit(200);
    assertEquals(250, account.getBalance());
  }

  @Test
  public void accountMakesWithdrawal() {
    account.deposit(100);
    account.withdraw(50);
    assertEquals(50, account.getBalance());
  }

  @Test
  public void accountMakesDifferentWithdrawal() {
    account.deposit(100);
    account.withdraw(100);
    assertEquals(0, account.getBalance());
  }
}
