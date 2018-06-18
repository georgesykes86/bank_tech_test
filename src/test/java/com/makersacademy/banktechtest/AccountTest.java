package com.makersacademy.banktechtest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() {
    account = new Account();
    account.deposit(100);
  }

  @Test
  public void accountHasBalance() {
    Account newAccount = new Account();
    assertEquals(0, newAccount.getBalance());
  }

  @Test
  public void accountMakesDeposit() {
    assertEquals(100, account.getBalance());
  }

  @Test
  public void accountMakesSecondDeposit() {
    account.deposit(150);
    assertEquals(250, account.getBalance());
  }

  @Test
  public void accountMakesWithdrawal() {
    account.withdraw(50);
    assertEquals(50, account.getBalance());
  }

  @Test
  public void accountMakesDifferentWithdrawal() {
    account.withdraw(100);
    assertEquals(0, account.getBalance());
  }
  
}
