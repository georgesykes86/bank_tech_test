package com.makersacademy.banktechtest;

import com.makersacademy.banktechtest.Exceptions.InvalidTransactionAmountException;

public class TransactionValidator {

  public TransactionValidator() {}

  public void validateTransaction(float amount) throws InvalidTransactionAmountException {
    if(amount <= 0 ) throw new InvalidTransactionAmountException("Amount must be greater than Zero");
  }

}
