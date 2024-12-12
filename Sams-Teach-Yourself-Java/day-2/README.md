# Sams Teach Yourself Java in 21 Days

## Day 2: The ABC of Programming

### Statements and Expressions

### Variables and Data Types

Java has three kinds of variables: instance variables, class variables, and local variables.

Instance variables, as you learned yesterday, define an object's attributes.

Class variablesdefine the attributes of an entire class of objects and apply to all instances of it.

Local variables are used inside method definitions or even smaller blocks of statements with a method.

### Creating Variables

Create a variable by declaring its name and the type of information it will store.

Local variables can be declared at any place inside a method, and must be declared before they are used.

### Naming Variables

### Variable Types

* Primitive data types, such as int or boolean
* The name of a class or interface
* An array

### Data Types

Java has eight basic data types that store integers, floating-point numbers, characters and Boolean values.

Integer types:
* byte - 8 bits
* short - 16 bits
* int - 32 bits
* long - 64 bits

Floating point numbers can be declared as `float` or `double`.

The `char` type is for individual characters.

The Boolean data type is `boolean`.

### Class Types

```
String lastName = "Hopper";
Color hair ;
VolcanoRobot vr;
```

### Assigning Values to Variables

An equals sign (=) is used to assign values to variables

### Constants

A *constant* is a variable with a value that never changes.
The `final` keyword is used to define a constant.

```
final float PI = 3.141592 ;
final boolean DEBUG = false;
final int PENALTY = 25 ;
```