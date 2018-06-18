package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.makersacademy.banktechtest.Transaction;
import com.makersacademy.banktechtest.TransactionRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TransactionRepositoryTest {

  private TransactionRepository repository;

  @Mock
  private Transaction transaction;

  @BeforeEach
  public void setUp() {
    repository = new TransactionRepository();
  }

  @Test
  public void hasNoTransactionsInitially() {
    assertEquals(new ArrayList<Transaction>(), repository.getTransactions());
  }

}
