package com.makersacademy.banktechtest;

public class ZeroBalanceException extends Exception {

  public ZeroBalanceException() {}

  public ZeroBalanceException(String message) {
    super(message);
  }
}
