package com.makersacademy.banktechtest.Unit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.Exceptions.InvalidTransactionAmountException;
import com.makersacademy.banktechtest.Printer;
import com.makersacademy.banktechtest.Statement;
import com.makersacademy.banktechtest.Transaction;
import com.makersacademy.banktechtest.TransactionRepository;
import com.makersacademy.banktechtest.Exceptions.ZeroBalanceException;
import com.makersacademy.banktechtest.TransactionValidator;
import java.util.ArrayList;
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

  @Mock
  private Statement statement;

  @Mock
  private TransactionValidator validator;

  private final ArrayList<Transaction> transactions = new ArrayList<>();
  private final float balance = 100;

  @BeforeEach
  public void setUp() throws InvalidTransactionAmountException {
    MockitoAnnotations.initMocks(this);
    when(statement.toString()).thenReturn(returnString);
    account = new Account(repository, printer, statement, validator);
    account.deposit(balance);
  }

  @Test
  public void accountHasZeroBalanceInitially() {
    Account newAccount = new Account(repository, printer, statement, validator);
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
    verify(repository).addTransaction(150, balance + 150);
  }

  @Test
  public void accountMakesAnotherNewTransactionOnDeposit() throws InvalidTransactionAmountException {
    account.deposit(250);
    verify(repository).addTransaction(250, balance + 250);
  }

  @Test
  public void validatesDepositAmount() throws InvalidTransactionAmountException {
    account.deposit(10);
    verify(validator).validateTransaction(10);
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
    Account newAccount = new Account(repository, printer, statement, validator);
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
  public void validatesWithdrawalAmount() throws InvalidTransactionAmountException, ZeroBalanceException {
    account.withdraw(10);
    verify(validator).validateTransaction(10);
  }

  @Test
  public void accountCreatesTransactionOnWithdrawal() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.withdraw(80);
    verify(repository).addTransaction(-80, balance - 80);
  }

  @Test
  public void accountCreatesTransactionOnDifferentWithdrawal() throws ZeroBalanceException,
      InvalidTransactionAmountException {
    account.withdraw(10);
    verify(repository).addTransaction(-10, balance - 10);
  }

  @Test
  public void printsCorrectString() {
    account.printStatement();
    verify(printer).print(returnString);
  }

  @Test
  public void createsStatement() {
    account.printStatement();
    verify(repository).getTransactions();
    verify(statement).setTransactions(any());
  }

}
