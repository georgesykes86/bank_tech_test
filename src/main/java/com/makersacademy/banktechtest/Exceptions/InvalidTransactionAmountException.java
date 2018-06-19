package com.makersacademy.banktechtest.Exceptions;

public class InvalidTransactionAmountException extends Exception {

  public InvalidTransactionAmountException() {}

  public InvalidTransactionAmountException(String message) {
    super(message);
  }

}
