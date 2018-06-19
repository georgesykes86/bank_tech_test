package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.makersacademy.banktechtest.Account;
import com.makersacademy.banktechtest.Transaction;
import com.makersacademy.banktechtest.TransactionFactory;
import com.makersacademy.banktechtest.TransactionRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TransactionRepositoryTest {

  private TransactionRepository repository;

  @Mock
  private Account account;

  @Mock
  private Transaction transaction;

  @Mock
  private TransactionFactory factory;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(factory.getTransaction()).thenReturn(transaction);
    when(transaction.toString())
        .thenReturn("String")
        .thenReturn("SecondString");
    repository = new TransactionRepository(factory);
  }

  @Test
  public void hasNoTransactionsInitially() {
    assertEquals(new ArrayList<Transaction>(), repository.getTransactions());
  }

  @Test
  public void addsTransaction() {
    repository.addTransaction(10, account);
    assertEquals(1, repository.getTransactions().size());
    assertTrue(repository.getTransactions().contains(transaction));
  }

  @Test
  public void passesAccountToTransaction() {
    repository.addTransaction(10, account);
    verify(transaction).buildTransaction(10, account);
  }

}
