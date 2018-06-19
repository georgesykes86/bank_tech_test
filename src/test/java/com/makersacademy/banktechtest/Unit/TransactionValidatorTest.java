package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.makersacademy.banktechtest.Exceptions.InvalidTransactionAmountException;
import com.makersacademy.banktechtest.TransactionValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionValidatorTest {

  private TransactionValidator validator;

  @BeforeEach
  public void setUp() {
    validator = new TransactionValidator();
  }

  @Test
  public void throwsCorrectMessageWithInvalidTransactionAmount() {
    Throwable exception = assertThrows(InvalidTransactionAmountException.class, () -> {
      validator.validateTransaction(-10);
    });
    assertEquals("Amount must be greater than Zero", exception.getMessage());
  }

  @Test
  public void throwsErrorIfZeroDepositAmountEntered() {
    assertThrows(InvalidTransactionAmountException.class, () -> { validator.validateTransaction(0); });
  }

  @Test
  public void noErrorThrownForPositiveTransactionAmount() {
    Exception error = null;
    try{
      validator.validateTransaction(10);
    } catch(Exception err) { error = err; }
    assertEquals(null, error);
  }

}
