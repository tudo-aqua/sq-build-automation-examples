package com.acme;

/**
 * A command-line based greeter.
 *
 * @author <a href="mailto:simon.dierl@cs.tu-dortmund.de">Simon Dierl</a>
 */
public class GreeterCLI {

  /** The greeter instance to use. */
  private static final Greeter greeter = new Greeter();

  /**
   * Print the requested greeting.
   *
   * @param args the first parameter is printed; if none is given, a generic greeting is emitted.
   */
  public static void main(final String... args) {
    final String thing = (args.length == 0) ? "World" : args[0];
    System.out.println(greeter.greet(thing));
  }
}
