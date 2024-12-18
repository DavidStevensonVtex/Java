# Sams Teach Yourself Java in 21 Days

## Day 6: Packages, Interfaces, and Other Class Features

### Modifiers

* access modifiers: `public`, `protected` and `private`
* `static` modifier for creating class methods and variables
* The `final` modifier for finalizing the implementation of classes, methods and variables
* The `abstract` modifier for creating abstract classes and methods
* The `synchronized` and `volatile` modifiers

#### Access Control for Methods and Variables

* public
* private
* protected
* default

`Encapsulation`: An object controls what the outside world can know about it and how the outside world can interact with it.

##### Default Access

A variable or method declared without an access control modifier is available to any other class in the same package.

Any variable declared without a modifier can be read or changed by any other class in the same package.

##### Private Access

To completely hide a method or variable and keep it from being used by other classes, use the `private` modifer.

Private variables are useful in two circumstances:

* When other classes have no reason to use that variable
* When another class could wreak havoc by changing the variable in an inappropriate way.

Using the `private` modifier is the main way in which an object encapsulates itself.

##### Public Access

You may want a method or variable in a class to be completely available to any other class that wants to use it.

Class variables often are declared to be public.

The main() method of an application has to be public.

Because of class inheritance, all public methods and variables of a class are inherited.

##### Protected Access

The next level of access control is to limit a method and a variable to use by following two groups:

* Subclasses of a class
* Other classes in the same package

##### Comparing Levels of Access Control

##### Access Control and Inheritance

When you create a subclass and override a method, you must consider the access control in place on the original method.

As a general rule, you cannot override a method in Java and make the new method more restrictively controlled than the original. You can, however, make it more public.

* Methods declared public in a superclass also must be public in all subclasses.
* Methods declared protected in a superclass must be either protected or public in subclasses; they cannot be private.
* Methods declared without access control (no modifier was used) can be declared more private in subclasses.

Methods declared private are not inherited, so the rules don't apply.

##### Accessor Methods

You can give other classes access to a private variable by using an accessor method inside the same class.

### Static Variables and Methods

The `static` modifier is used to create class methods and variables.

```
public class Circle {
    public static final float PI = 3.14159265F ;

    public float area (float r) {
        return PI * r * r;
    }
}
```

The following statements use class variables and methods:

```
float circumference = 2 * Circle.PI * getRadius();
float randomNumber = Math.random();
```

### Final Classes, Methods and Variables

The `final` modifier is used with classes, methods and variables to indicate that they will never be changed.

* A `final` class cannot be subclassed.
* A `final` method cannot be override by any subclasses.
* A `final` variable cannot change in value.

#### Final Variables

The `final` modifier is often used with `static` to make the constant a class variable.

```
public static final int TOUCHDOWN = 6 ;
static final String TITLE = "Captain" ;
```

#### Final Methods

Final methods can never be overridden by a subclass.

```
public final void getSignature() {
    // body of method
}
```

Private methods are final without being declared that way because they can't be overridden in a subclass under any circumstance.

#### Final Classes

A `final` class *cannot* be subclassed by another class.

```
public final class ChatServer {
    // body of method
}
```

All methods in a final class are automatically final themselves.

### Abstract Classes and Methods

In a class hierarchy, the higher the class, the more abstract its definition.

When you factor out common behavior and attributes during the process of defining a hierarchy of classes, you might at times find yourself with a class that never needs to be instantiated directly. Instead, such a class serves as a place to hold common behavior and attributes shared by their subclasses.

```
public abstract class Palette {
    // ...
}
```

Abstract classes can contain anything a normal class can, including c onstructors, because their subclasses might need to inherit them. 

Abstract classes can also contain abstract methods, which are method signatures with no implementation. These methods are implemented in subclasses of the abstract class. Abstract methods are declared with the `abstract` modifier.

If your abstract class has nothing but abstract methods,you're better off using an interface.

### Packages

Packages are a way of organizing groups of classes.

Packages are useful for several broad reasons:

* They enable you to organize your classes into units.
* They reduce problems with conflicts about names.
* They enable you to protect classes, variables and methods in larger ways that on a class-by-class basis.
* Packages can be used to uniquely identify your work.

#### The `import` Declaration

`import java.util.Vector`

`import java.awt.*`

`import java.util.*`

This merely imports the `java.util` package.

```
import java.uti.*;
import java.util.jar.*;
import java.util.prefs.*;
```

You cannot indicate partial class names (such as l* to import all the classes that begin with the letter L).

The `import` declarations in your class definition go at the top of the file, before any class definitions but after the package declaration.

An `import static` statement makes the constants in an identified class available in shorter form. The keywords `import static` are followed by the name of an interface or class and an asterisk.

`import static java.lang.Math.*;`

```
import static java.lang.Math.* ;

public class ShortCosntants {
    pubic static void main(String[] arguments) {
        System.out.println("PI: " + PI);
        System.out.println("" + (PI *3));
    }
}
```

#### Class Name Conflicts

`java.util` and `java.sql` both contain a class named `Date`.

`import java.sql*`;
`import java.util.*`

`java.util.Date = new java.util.Date();`

### Creating Your Own Packages

#### Picking a Package Name

If you intend to distribute your package as an open source or commercial product, use a package name that uniquely identifies its authorship.

Oracle recommends that Java developers use an Internet domain name that you control as the basis for a unique package name.

By another convention, package names use no capital letters, which distinguishes them from class names.

#### Creating the Folder Structure

Createa folder structure that matches the package name, which requires a separate folder for each part of the name.

#### Adding a Class to a Package

Add a statement to the class file above any import declarations and the class declaration. The package declaration is followed by the full name of the package:

`package org.cadenhead.rss`

The package declaration must be the first line of code in your source file, disregarding comments or blank lines.

#### Packages and Class Access Control

Classes have the default access control if no modifier is specified, which means that the class is available to all other classes in the same package but is not visible or available outside of that package.

To allow a class to be visible and importable outside your package, you can give it public protection by adding the `public` modifier to its definition:

```
public class Visible {
    // ...
}
```

Classes declared as public can be accessed by classes outside the package.

Note that when you use an `import` statement with an asterisk, you import only the public classes inside that package. Other c lasses remain hidden and can be used only by other c lasses in that package.

Creating a good package consists of defining a small, clean set of public classes and methods for other classes to use and then implementing them by using any number of hidden support classes.

### Interfaces

Interfaces, like abstract classes and methods, provide templates of behavior that other classes are expected to implement.

#### The Problem of Single Inheritance

Java supports only single inheritance for the reason of simplicity.

A Java interface is a collection of abstract behavior that can be adopted by any class without being inherited from a superclass.

An interface contains nothing but abstract method definitions and constants. It has no instance variables or method implementations.

Example: `java.lang.Comparable`

#### Interfaces and Classes

Interfaces and classes are somewhat interchangeable.

An interface cannot be instantiated. `new` can only create an instance of a non-abstract class.

#### Implementing and Using Interfaces

To use an interface, include the `implements` keyword as part of your class definition.

`public class AnimatedSign extends Sign implements Runnable {
    // ...
}

To implement an interface, you must implement all of the methods that interface defines.

After your class implements an interface, subclasses of your class inherit those new methods and can override or overload them. 

Ify our class inherits from a superclass that implements a given interface, you don't have to include the `implements` keyword in your own class definition.

