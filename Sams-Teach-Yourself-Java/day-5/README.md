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