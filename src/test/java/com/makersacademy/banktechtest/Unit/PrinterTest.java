package com.makersacademy.banktechtest.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.makersacademy.banktechtest.Printer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrinterTest {

  private final ByteArrayOutputStream output = new ByteArrayOutputStream();
  private Printer printer;

  @BeforeEach
  public void setUp() {
    printer = new Printer();
    System.setOut(new PrintStream(output));
  }

  @Test
  public void printsString() {
    printer.print("Test String");
    assertEquals("Test String", output.toString());
  }

  @Test
  public void printsDifferentString() {
    printer.print("Another Test String");
    assertEquals("Another Test String", output.toString());
  }
}
