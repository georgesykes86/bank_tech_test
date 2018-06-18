package com.makersacademy.banktechtest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ZeroBalanceExceptionTest {

  @Test
  public void isThrowable() {
    assertThrows(ZeroBalanceException.class, () -> { throw new ZeroBalanceException(); });
  }

}
