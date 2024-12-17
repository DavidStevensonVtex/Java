# Sams Teach Yourself Java in 21 Days

## Day 5: Creating Classes and Methods

### Defining Classes

A class is defined via the class keyword and the name of the class.

```
class Ticker {
    // body of the class
}
```

By default, classes inherit from the Objet class. It's the superclass of all classes in the Java class hierarchy.

class SportsTicker extends Ticker {
    // body of the class
}

### Creating Instance and Class Variables

#### Defiing Instance Variables

Instance variables are declared and definedi n almost the same manner as local variables.
The main difference is their location in the class definition.

Variables are considered instance variables if they are declared outside of a method definition and are not modified by the `static` keyword.

by programming custom, most instance variables are defined right after the first line of the class definition, but thye could just as easily be defined at the end.

```
class VolcanoRobot extends Sciencerobot {
    String status;
    int speed;
    float temperature;
    int power;
}
```

#### Class Variables

Class variables apply to a class as a whole, rather than a particular object of that class.

Class variables are good for sharing information between different objects of the same class or for keeping track of common information among a set of objects.

The `static` keyword is used in the class declaration to declre a class variable.

```
static int SUM;
static final in MAXOBJECTS = 10;
```

### Creating Methods

#### Defining Methods

A method definition has four basic parts:

* The method's name
* A list of parameters and their type
* The type of object or primitive type that the method returns
* the body of the method

```
returnType methodName(type1 arg1, type2 arg2, type3 arg3, ...) {
    // body of the method
}
```

#### The `this` Keyword

`this` is a reference to the current instance of a class. Use it only inside the body of an instance method definition.

Use the `this` keyword where you normally would refere to an object's name.

```
x = this.x;
z.resetData(this);
return this;
```

#### Variable Scope and Method Definition

*Scope* is the part of a program in which a variable or another type of information exists, making it possible to use variable in statements and expressions.

When you declare a variable in Java, that variable always has limited scope.

#### Passing Arguments to Methods

#### Class Methods

### Creating Java Applications

Applications are Jav classes that can be run on their own.

The signature for the main() method takes the following format:

```
public static void main(String[] arguments) {
    // body of method
}
```

#### Helper Classes

### Java Applications and Command-Line Arguments

`java EchoArgs April 450 -10`

To group arguments that include spaces, surround the arguments with quotation marks.

#### Handling Arguments in Your Java Application

```
public static void main(String[] arguments) {
    // body of method
}
```

*arguments* is the name of the array of strings that contains the list of command line arguments.
You can call this array anything you want.

### Creating Methods with the Same Name

When you work with the Java Class Library, you often encounter classes that have numerous methods with the same name.

Two things differentiate thise same named methods:
* The number of arguments theytake.
* The primitive type or object type of each argument

Using several methods with the same name and different signatures is called *overloading*.

Method overloading can eliminate the need for entirely different methods that do essentially the same thing. Overloading also makes it possible for methods to behave differently based on the arguments they receive.

### Constructors

A constructor is a method called on an object when it is created -- in other words, when it is constructed.

When an object is created of a class that has no constructors, a constructor with no arguments is implicitly provided by Java.

#### Basic Constructors

Constructors look like regular methods, with three basic differences:

* They always have the same name as the class
* They don't have a return type
* The cannot return a value in the method by using the `return` statement

```
class VolcanoRobot {
    String status;
    int speed;
    int power;

    VolcanoRobot(String in1, int in2, int in3) {
        status = in1;
        speed = in2;
        power = in3;
    }
}
```

#### Calling Another Constructor

Use the following code to calla constructor defined in the current class:

`this(arg1, arg2, arg3)`

```
class Circle {
    int x, y, radius;

    Circle(int xPoint, int yPoint, int radiusLength) {
        this.x = xPoint;
        this.y = yPoint ;
        this.radius = radiusLength;
    }

    Circle(int xPoint, int yPoint) {
        this(xPoint, yPoint, 1);
    }
}

#### Overloading Constructors

Like methods, Constructors can also take varying numbers and types of parameters.
