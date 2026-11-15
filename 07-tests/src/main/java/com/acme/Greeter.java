package com.acme;

/**
 * Factory for greeting arbitraty things in the english language.
 *
 * @author <a href="mailto:simon.dierl@cs.tu-dortmund.de">Simon Dierl</a>
 */
public final class Greeter {

  /**
   * Render a greeting.
   *
   * @param thing the object to greet.
   * @return a greeting for the defined object.
   */
  public String greet(final String thing) {
    return "Hello, " + thing;
  }
}
