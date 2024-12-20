# Sams Teach Yourself Java in 21 Days

## Day 7: Exceptions and Threads

### Exceptions

#### Exception Classes

Just as exceptions are throw, they can also be caught.

Exceptions in Java are instances of classes that inherit from the `Throwable` class. An instance of a `Throwable` class is created when an exception is thrown.

`Throwable` has two subclasses: `Error` and `Exception`. Instances of `Error` are internal errors involving the Java virtual machine (the runtime environment). 

The class `Exception` is more relevant to your own programming. Subclasses of `Exception` fall into two general groups:

* Unchecked exceptions - ArrayIndexOutOfBoundsException, SecurityException and NullPointerException
* Checked exceptions such as EOFException and MalformedURLException

Exceptions are arranged in a hierarchy just as other classes are, where the superclasses are more general kinds of problems and subclasses are more specific.

The primary exception classes are part of the `java.lang` package: `Throwable`, `Exception` and `RuntimeException`.

The `java.io` package defines a general exception class called `IOException`.