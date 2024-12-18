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