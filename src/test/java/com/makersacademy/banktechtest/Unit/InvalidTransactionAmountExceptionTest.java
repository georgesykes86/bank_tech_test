package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.makersacademy.banktechtest.InvalidTransactionAmountException;
import org.junit.jupiter.api.Test;

public class InvalidTransactionAmountExceptionTest {

  @Test
  public void isThrowableWithoutMessage() {
    assertThrows(InvalidTransactionAmountException.class, () -> {
      throw new InvalidTransactionAmountException();
    });
  }

  @Test
  public void hasErrorMessageWhenThrown() {
    Throwable exception = assertThrows(InvalidTransactionAmountException.class, () -> {
      throw new InvalidTransactionAmountException("Incorrect Amount");
    });
    assertEquals("Incorrect Amount", exception.getMessage());
  }

  @Test
  public void throwsWithDifferentErrorMessage() {
    Throwable exception = assertThrows(InvalidTransactionAmountException.class, () -> {
      throw new InvalidTransactionAmountException("Negative amount");
    });
    assertEquals("Negative amount", exception.getMessage());
  }
}
