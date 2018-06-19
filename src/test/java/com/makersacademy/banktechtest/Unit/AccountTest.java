package com.makersacademy.banktechtest.Unit;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.Printer;
import com.makersacademy.banktechtest.TransactionRepository;
import com.makersacademy.banktechtest.ZeroBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AccountTest {

  private Account account;
  private final String returnString = "This Return String";

  @Mock
  private TransactionRepository repository;

  @Mock
  private Printer printer;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(repository.printTransactions()).thenReturn(returnString);
    account = new Account(repository, printer);
    account.deposit(100);
  }

  @Test
  public void accountHasZeroBalanceInitially() {
    Account newAccount = new Account(repository, printer);
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
  public void accountMakesNewTransactionOnDeposit() {
    account.deposit(150);
    verify(repository).addTransaction(150, account);
  }

  @Test
  public void accountMakesAnotherNewTransactionOnDeposit() {
    account.deposit(250);
    verify(repository).addTransaction(250, account);
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
    Account newAccount = new Account(repository, printer);
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

  @Test
  public void printsCorrectString() {
    account.printStatement();
    verify(printer).print("date || credit || debit || balance\n" + returnString);
  }

}
