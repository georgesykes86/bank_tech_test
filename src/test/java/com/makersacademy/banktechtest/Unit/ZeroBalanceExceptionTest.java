package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.makersacademy.banktechtest.ZeroBalanceException;
import org.junit.jupiter.api.Test;

public class ZeroBalanceExceptionTest {

  @Test
  public void isThrowableWithoutMessage() {
    assertThrows(ZeroBalanceException.class, () -> { throw new ZeroBalanceException(); });
  }

  @Test
  public void hasErrorMessageWhenThrown() {
    Throwable exception = assertThrows(ZeroBalanceException.class, () -> {
      throw new ZeroBalanceException("Insufficient Funds");
    });
    assertEquals("Insufficient Funds", exception.getMessage());
  }

  @Test
  public void throwsWithDifferentErrorMessage() {
    Throwable exception = assertThrows(ZeroBalanceException.class, () -> {
      throw new ZeroBalanceException("Too Many Funds");
    });
    assertEquals("Too Many Funds", exception.getMessage());
  }

}
