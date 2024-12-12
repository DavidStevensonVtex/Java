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

### Comments

A single-line comment is preceded by two slash characters.

A multiline comment begins with /* and ends with */.

A Javadoc comment begins with /** and ends with */

### Java Platform Standard Edition 7 Documentation

[Java Platform Standard Edition 7 Documentation](https://docs.oracle.com/javase/7/docs/)

### Literals

A *literal* is any number, text, or other information that directly represents a value.

#### Number Literals

A literal that should be a long integer should have an uppercase L suffix.

Floating point values for the `float` data type should have an uppercase F suffix.

You can use exponents in floating-point literals by using the letter e or E.

#### Boolean Literals

*true* or *false*

```boolean chosen = true;```

#### Character Literals

Character literals are expressed by a single character surrounded by single quotation marks, such as 'a', '#', and '3'.

Character escape codes

#### String Literals

A string in Java is an object rather than a primitive data type.
Strings are not stored in arrays in Java.

`String quitMsg = "Are you sture you want to quit?";`

### Expressions and Operators

An *expression* is a statement that can convey a value.

```
int x = 3;
int y = x;
int z = x * y;
```

The value convenyed by an expression is called a *return value*.

#### Arithmetic

Arithmetic operators
* \+
* \-
* \*
* \/
* \% -Modulus

### More About Assignment

`x = y = z = 7;`

Assignment Operators
```
x += y;
x -= y;
x *= y;
x /= y;
```

### Incrementing and Decrementing

```
x++;
x--;
```

### Comparisons

* ==
* != 
* \<
* \>
* <=
* \>=

### Logical Operators

AND, OR, XOR and logical NOT

For AND combinations, the & or && logical operator is used.

The difference between & and && lies in how much work Java does no the combined expression. If & is used, expressiosn on both sides of the & are evaluated no matter what. If && is used, and the left side is false, the expresion the right side of the && is never evaluated.

For OR combinations, the | or || logical operator is used.
These combined expressions return atrue value if either Boolean expression is true.
Only if both of these expressions are false is the value false assigned.

The XOR combination has one logical oiperator: ^. This results in a true value only if 
the Boolean expressions it combines have opposite  values.

The NOT combination uses the ! logical operator followed by a single expression.

### Operator Precedence

To change the order in which expressions are evaluated, place parentheses around the expressions that should be evaluated first.

Parentheses also can improve an expression's readability.