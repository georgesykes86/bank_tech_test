package com.makersacademy.banktechtest.Unit;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.InvalidTransactionAmountException;
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
  public void setUp() throws InvalidTransactionAmountException {
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
  public void accountMakesSecondDeposit() throws InvalidTransactionAmountException {
    account.deposit(150);
    assertEquals(250, account.getBalance());
  }

  @Test
  public void accountMakesNewTransactionOnDeposit() throws InvalidTransactionAmountException {
    account.deposit(150);
    verify(repository).addTransaction(150, account);
  }

  @Test
  public void accountMakesAnotherNewTransactionOnDeposit() throws InvalidTransactionAmountException {
    account.deposit(250);
    verify(repository).addTransaction(250, account);
  }

  @Test
  public void throwsErrorIfNegativeDepositAmountEntered() {
    assertThrows(InvalidTransactionAmountException.class, () -> { account.deposit(-100); });
  }

  @Test
  public void throwsErrorIfZeroDepositAmountEntered() {
    assertThrows(InvalidTransactionAmountException.class, () -> { account.deposit(0); });
  }

  @Test
  public void accountMakesWithdrawal() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.withdraw(50);
    assertEquals(50, account.getBalance());
  }

  @Test
  public void accountMakesDifferentWithdrawal() throws ZeroBalanceException,
      InvalidTransactionAmountException {
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
  public void accountDoesntThrowErrorWhenWithdrawalMakesZeroBalance() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.withdraw(100);
    assertEquals(0, account.getBalance());
  }

  @Test
  public void throwsErrorIfNegativeWithdrawalAmountEntered() {
    assertThrows(InvalidTransactionAmountException.class, () -> { account.withdraw(-100); });
  }

  @Test
  public void throwsErrorIfZeroWithdrawalAmountEntered() {
    assertThrows(InvalidTransactionAmountException.class, () -> { account.withdraw(0); });
  }

  @Test
  public void accountCreatesTransactionOnWithdrawal() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.withdraw(80);
    verify(repository).addTransaction(-80, account);
  }

  @Test
  public void accountCreatesTransactionOnDifferentWithdrawal() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.withdraw(10);
    verify(repository).addTransaction(-10, account);
  }

  @Test
  public void printsCorrectString() {
    account.printStatement();
    verify(printer).print("date || credit || debit || balance\n" + returnString);
  }

}
