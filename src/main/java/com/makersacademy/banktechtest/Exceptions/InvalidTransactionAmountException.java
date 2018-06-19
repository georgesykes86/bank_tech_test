package com.makersacademy.banktechtest;

public class InvalidTransactionAmountException extends Exception {

  public InvalidTransactionAmountException() {}

  public InvalidTransactionAmountException(String message) {
    super(message);
  }

}
