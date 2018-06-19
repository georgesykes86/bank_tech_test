package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.makersacademy.banktechtest.Transaction;
import com.makersacademy.banktechtest.TransactionFactory;
import org.junit.jupiter.api.Test;

public class TransactionFactoryTest {

  private TransactionFactory transactionFactory = new TransactionFactory();

  @Test
  public void returnsANewFactory() {
    Object transaction = transactionFactory.getTransaction();
    assertTrue(transaction instanceof Transaction);
  }

}
