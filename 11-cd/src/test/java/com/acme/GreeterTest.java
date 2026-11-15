package com.acme;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class GreeterTest {
  @Test
  public void testSimpleGreeting() {
    final Greeter greeter = new Greeter();

    final String greeting = greeter.greet("Test");

    assertEquals("Hello, Test", greeting);
  }

  @Test
  public void testNullGreeting() {
    final Greeter greeter = new Greeter();

    final String greeting = greeter.greet(null);

    assertEquals("Hello, null", greeting);
  }
}
