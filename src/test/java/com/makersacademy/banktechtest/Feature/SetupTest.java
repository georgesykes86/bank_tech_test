package com.makersacademy.banktechtest.Feature;

import com.makersacademy.banktechtest.BankRunner;
import com.makersacademy.banktechtest.Exceptions.InvalidTransactionAmountException;
import com.makersacademy.banktechtest.Exceptions.ZeroBalanceException;
import org.junit.jupiter.api.Test;

public class SetupTest {

  @Test
  public void runsTheApp() throws ZeroBalanceException, InvalidTransactionAmountException {
    BankRunner.main(new String[] {"arg1", "arg2"});
  }

}
