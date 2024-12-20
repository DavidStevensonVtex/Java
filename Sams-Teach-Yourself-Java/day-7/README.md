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

### Managing Exceptions

#### Exception Consistency Checking

```
Exception java.lang.InterruptedException must be caught or it must be  declared in the throws clause of this method.
```
In Java, a method can indicate the kinds of errors it might potentially throw. For example, methods that read from files can throw `IOException` errors, so those methods are declared with a special modifier that indicates potential errors.

This rule is enforced by the compiler itself, in the same way that it checks to make sure that you're using methods with the correct number of arguments and that your variable types match what you're assigning to them.

#### Protecting Code and Catching Exceptions

```
    public SquareTool(String input) {
        try {
            float in = Float.parseFloat(input) ;
            // ...
        }
        catch ( NumberFormatException nfe) {
            System.out.println(input + " is not a valid number.");
        }
    }
```

In this code, the `Float.parseFloat()` class method might throw an exception of type `NumberFormatException`.

```
    try {
        float in = Float.parseFloat(input) ;
        // ...
    }
    catch ( NumberFormatException nfe) {
        System.out.println("Oops: " + nfe.getMessage());
    }
```

```
try {
    // code that might generate exceptions
} catch ( IOException ioe) {
    System.out.println("Input/output error: " + ioe.getMessage());
} catch (ClassNotFoundException cnfe) {
    System.out.println("Class not found: " + cnfe.getMessage());
} catch (InterruptedException ie) {
    System.out.println("Program interrupted: " + ie.getMessage());
}
```

I Java 7, you can also catch more than one class of exceptions in the same `catch` statement.
The classes must be separated by a pipe character(|).

```
try {
    // code that reads a file from disk
} catch (EOFException | FileNotFoundException exc) {
    System.out.print("File error: " + exc.getMessage());
}
```

The exceptions declared as alternatives int the `catch` statement cannot be superclasses or subclasses of each other unless they are in the proper order. The following would not work:

```
try {
    // code that reads a file from disk
} catch (IOException | EOFException | FileNotFoundException exc) {
    System.out.print("File error: " + exc.getMessage());
}
```

`IOException` is a superclass of the other two exceptions.

Here's a fixed version that would work:

```
try {
    // code that reads a file from disk
} catch (EOFException | FileNotFoundException exc) {
    System.out.print("File error: " + exc.getMessage());
} catch (IOException ioe) {
    System.out.print("IO error: " + ioe.getMessage());
}
```

Another way to make it work would be to put the superclass last in the `catch` statement:

```
try {
    // code that reads a file from disk
} catch (EOFException | FileNotFoundException | IOException exc) {
    System.out.print("File error: " + exc.getMessage());
}
```