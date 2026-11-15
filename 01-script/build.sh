#!/bin/sh

javac \
  com/acme/Greeter.java \
  com/acme/GreeterCLI.java
jar -c -f greeter.jar -e com.acme.GreeterCLI \
  com/acme/Greeter.class \
  com/acme/GreeterCLI.class
