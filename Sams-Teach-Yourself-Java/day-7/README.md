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

#### The finally clause

Suppose there is some action in your code that you absolutely must do, no matter what happens, 
regardless of whether an exception is thrown.

```
try {
    readTextFile();
} catch (IOException ioe) {
    // deal with IO errors
} finally {
    closeTextFile();
}
```

Java 7 offers a new way to ensure that resources are freed properly even when an operation inside a `try` block fails with an exception. The `try-with-resources` featuer enables statements that claim resources to be declared inside parentheses in a `try` statement.

```
try (Socket digit = new Socket(host, 79);
    BufferedReader in = new BufferedReader(new InputStreamReader(digit.getInputStream()));
) {
    // code goes here
}
catch ( IOException e) {
    System.out.println("IO Error: " + e.getMessage());
}
```

### Declaring Methods That Might Throw Exceptions

#### The throws clause

```
public void getFormula(int x, int y) throws NumberFormatException {
    // body of method
}
```

Separate multiple exceptions with a comma.

```
public void getFormula(int x, int y) throws NumberFormatException, EOFException {
    // body of method
}
```

Note that, as with `catch`, you can use a superclass of a group of exceptions to indicate that your method might ghrow any subclass of that exception. For example:

```
public void loadFormula() throws IOException {
    // ...
}
```

The `throws` clause means that the method *might* throw an exception.

#### Which Exceptions Should You Throw?

In many instances, this is apparent from the operation of the method itself. Perhaps you're already creating and throwing your own exceptions.

You don't have to list all possible exceptions. Unchecked exceptions are handled by the runtime itself and are so common you don't have to deal with them.

In particular, exceptions of either the `Error` or `RuntimeException` class or any of their subclasses do not have to be listed in your `throws` clause.


* **Checked exceptions** are exceptions that are checked at compile time. This means that the compiler forces you to either handle these exceptions using a try-catch block or declare them in the method signature using the throws keyword.
* **Unchecked exceptions** are exceptions that are not checked at compile time. This means that you are not required to handle them explicitly.

*Checked exceptions* are potential c andidates for a `throws` clause in your method

#### Passing on Exceptions

There are times when it doesn't make sense for your method to deal with an exception. It might be better for the method that calls your method to deal with that exception.

One thing is always true: It's better to pass on exceptions to calling methods than to catch them and do nothnig in response.

```
public float readFloat(String input) throws NumberFormatException {
    return Float.parseFloat(input);
}
```

#### throws and Inheritance

If your method overrides a method in a superclass that includes a throws c lause, there are special rules for how your overriden method deals with `throws`. The overridden method does not require the same set of exceptions listed in the throws clause.

```
public class RadioPlayer {
    public void starPlaying() throws SoundException {
        // body of method
    }
}

public class StereoPlayer extends RadioPlayer {
    public void startPlaying() {
        // body of method
    }
}
```

A subclass method cannot throw more checked exceptions than its superclass method.

