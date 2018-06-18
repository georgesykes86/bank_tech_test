package com.makersacademy.banktechtest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account = new Account();

    @Test
    public void accountHasBalance() {
        assertEquals(0, account.getBalance());
    }
}
