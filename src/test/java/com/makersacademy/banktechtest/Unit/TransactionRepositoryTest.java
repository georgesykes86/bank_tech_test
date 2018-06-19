package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.makersacademy.banktechtest.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TransactionRepositoryTest {

  private TransactionRepository repository;

  @Mock
  private Transaction transaction;

  @Mock
  private TransactionFactory factory;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(factory.getTransaction()).thenReturn(transaction);
    repository = new TransactionRepository(factory);
    repository.addTransaction(10, 100);
  }

  @Test
  public void hasNoTransactionsInitially() {
    TransactionRepository newRepo = new TransactionRepository(factory);
    assertEquals(new ArrayList<Transaction>(), newRepo.getTransactions());
  }

  @Test
  public void addsTransaction() {
    assertEquals(1, repository.getTransactions().size());
    assertTrue(repository.getTransactions().contains(transaction));
  }

  @Test
  public void addsMultipleTransactions() {
    repository.addTransaction(10, 100);
    assertEquals(2, repository.getTransactions().size());
  }

  @Test
  public void passesAccountToTransaction() {
    verify(transaction).buildTransaction(10, 100);
  }

}
