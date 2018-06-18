package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.ZeroBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

  private Account account;

  @BeforeEach
  public void setUp() {
    account = new Account();
    account.deposit(100);
  }

  @Test
  public void accountHasZeroBalanceInitially() {
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
  public void accountMakesWithdrawal() throws ZeroBalanceException {
    account.withdraw(50);
    assertEquals(50, account.getBalance());
  }

  @Test
  public void accountMakesDifferentWithdrawal() throws ZeroBalanceException {
    account.withdraw(80);
    assertEquals(20, account.getBalance());
  }

  @Test
  public void accountThrowsErrorIfZeroBalance() {
    Account newAccount = new Account();
    Throwable exception = assertThrows(ZeroBalanceException.class, () -> {
      newAccount.withdraw(100);
    });
    assertEquals("Insufficient Funds", exception.getMessage());
  }

  @Test
  public void accountThrowsErrorIfWithdrawalWillCauseNegativeBalance() {
    assertThrows(ZeroBalanceException.class, () -> { account.withdraw(101); });
  }

  @Test
  public void accountDoesntThrowErrorWhenWithdrawalMakesZeroBalance() throws ZeroBalanceException {
    account.withdraw(100);
    assertEquals(0, account.getBalance());
  }

}
