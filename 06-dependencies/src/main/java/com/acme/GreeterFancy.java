package com.acme;

/**
 * A command-line based greeter with a fancy flowerbox.
 *
 * @author <a href="mailto:simon.dierl@cs.tu-dortmund.de">Simon Dierl</a>
 */
public class GreeterFancy {

  /** The greeter instance to use. */
  private static final Greeter greeter = new Greeter();

  /**
   * Print the flowerboxed greeting.
   * @param args the first parameter is printed; if none is given, a generic greeting is emitted.
   */
  public static void main(final String... args) {
    final String thing = (args.length == 0) ? "World" : args[0];
    final String greeting = greeter.greet(thing);

    final String outer = "+-" + "-".repeat(greeting.length()) + "-+";

    System.out.println(outer + "\n| " + greeting + " |\n" + outer);
  }

}
