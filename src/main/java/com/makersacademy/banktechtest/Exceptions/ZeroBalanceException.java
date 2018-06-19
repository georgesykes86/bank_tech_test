package com.makersacademy.banktechtest.Exceptions;

public class ZeroBalanceException extends Exception {

  public ZeroBalanceException() {}

  public ZeroBalanceException(String message) {
    super(message);
  }

}
