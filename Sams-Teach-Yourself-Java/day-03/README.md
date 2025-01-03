# Sams Teach Yourself Java in 21 Days

## Day 3: Working with Objects

### Creating New Objects

Classes are templates (blueprints) used to create objects.

The String class is unusuall in that respect. Although it's a class,
it can be assigned a value with a literal as if it were a primitive type.

#### Using New

```
String name = new String("Hall Jordan");
URL address = new URL("http://www.java21days.com");
Volcanorobot robbie = new VolcanoRobot();
```

```
Random seed = new Random(606843071);
Point pt = new Point(0,0);
```
The number and type of arguments to include inside the parentheses are defined by
the class itself using a special method called a *constructor*.

#### How Objects Are Constructed

A *constructor# is a special way to create a new instance of a class.

A class can have several different constructors, each with a different number or type of arguments.
Whe nyou use new, you can specify different arguments in the argument list, and the corret constructor 
for those arguments are called.

No two constructors in a class can have the same numberand type of arguments.

#### A Note on Memory Management

Memory management in Java is dynamic and automatic. When you create a new object, Java
automatically allocates the proper amount of memory for the object.

You don't need to deallocate the memory an object uses when you're finished using the object.

The process of reclaiming unused memory from objects no longer used is called *garbage collection*.

### Using Class and Instance Variables

#### Getting Values

To get to the value of an instance variable, you use *dot notation*, a form of addressing in which an
instance or class variable name has two parts:

* A reference to an object or class on the left side of the dot operator (.).
* A variable on the right side.

`float total = customer.orderTotal;`

`float total = store.customer.orderTotal;`

#### Setting Values

`customer.layaway = true;`

#### Class Variables

Class variables are variables defined and stored in the class itself.
Their values apply to the class and all its instances.

Each instance can change the values of those instance variables without 
affecting any other instances.

```
class FamilyMember {
    static String surname = "Mendoza" ;
    String name;
    int age;
}
```

If a class has a `static` variable, every object of that class has the same value for that variable.

```
FamilyMember dad = new FamilyMember();
System.out.println("Family's surname is: " + dad.surname);
System.out.println("Family's surname is: " + FamilyMember.surname);
```

#### Calling Methods

Calling a method in an object also makes use of dot notation.

`customer.addtoCart(itemNumber, price, quantity);`

`customer.cancelOrder()`

#### Formatting Strings

Numbers such as money often need to be displayed in a precise manner.

`System.out.format()`

```
int accountBalance = 5005;
System.out.format("Balance: $%,d%n", accountBalance);
```

Output: `Balance: $5,005`

```
double pi = Math.PI;
System.out.format("%.11f%n", pi);
```

The output is 3.14159265359

#### Nesting Method Calls

A method can return a reference to an object, a primitive data type, or no value at all.

```
String label = "From" ;
String upper = label.toUpperCcase();
```

If the cancelOrder() method returns an object, you can call methods of that object in the same statement:

`customer.cancelOrder().fileComplaint()`

#### Class Methods

Class methods, like class variables apply to the class as a whole and not its instances.

For example, the String class contains a class method called valueOf(), which can take many different types of arguments (integer, Booleans, objets, and so on).

```
int firstPrice = 225;
int secondPrice = 217;
int higherPrice = Math.max(firstPrice, secondPrice);
```

```
String s, s2;
s = "item";
s2 = s.valueOf(550);
s2 = String.valueOf(550);
```

s2 will have the value of "550".

#### References to Objects

A *reference* is an address that indicates where the object's variables and methods are stored.

### Casting Objects and Primitive Types

You must use variables of the correct data types.

If a method requires an `int`, the Java compiler responds with an error if you
try to send a `float` value to th3e method.


In these situations, you can use a process called *casting* to convert a value from one to another.

Three types of casts and conversions:

* Casting between primitive types
* Casting from an object of a class to an object of another class
* Casting primitive types to objects, and then extracting primitive values from those objects

#### Casting Primitve Types

Casting between primitive types enables you to convert the value of one type to another primitive type.
This most commonly occurs with the numeric types.

You can automatically use a `byte` or `char` as an `int`; you can use an int as a long,
an int as a float, or any numeric value as a double. In these cases, no loss of information
occurs.

Cast an int or a long into a float, or a long to a double can cause some loss of precision.

You must use an explicit cast to convert a value in a large type to a smaller type. Explicit
casts take the following form:

`(typename) value`

#### Casting Objects

Objects of classes also can be cast into objects of other classes when the source and destination 
classes are related by inheritance and one class is a subclass of the other.

Because a  subclass contains all the ame information as its superclass, you can use an object of a
subclass anywhere a superclass is expected.

All Java classes are subclasses of Object.

Because subclasses contain more behavior (and data) than their superclasses, a loss of precision occurs in the casting.

To use superclass objects where subclass objects are expected, you must cast them explicitly.

```
Employee emp = new Employee();
VicePresident veep = new VicePresident();
emp = veep;                     // No cast needed for upward use
veep = (VicePresident) emp;     // must cast explicitly
```

#### Converting Primitive Types to Objects and Vice Versa

One thing you can't do under any circumstances is cast from an object to a primitive data type, or vice versa.

```
Integer dataCount = new Integer(7801);
int newCount = dataCount.intValue();    // returns 7801

String pensylvannia = "65000";
int penn = Integer.parseInt(pennsylvania);
```

the following classes can be used to work with objects instead of primitive data types:
boolean, Byte, Character, Double, Float, Integer, Long, Short, and Void.

Working with primtive types and objects that represent the same values is made easier through
autoboxing and unboxing, an automatic conversion process.

*Autoboxing* automatically converts a primitve type to an object, and *unboxing* converts
in the other direction.

```
Float f1 = new Float(12.5);
Float f2 = new Float(27.2F);
System.out.println("Lower number: " + Math.min(f1, f2));
```

The Math.min() method takes two float values as arguments, but the preceding example
sends the method two Float objects as arguments instead.

Float objects are automatically unboxed into float values before being sent to the min()
method.

### Comparing Object Values and Classes

Three other common tasks that involve objects:

* Comparing objects
* Finding out the class of any given object
* Testing to see whther an object is an instance of a given class

#### Comparing Objects

Most of these operators (==, !=, <, >, etc) work on primitives but not objects.

The exceptions to this rule are the == operator for equality and the != operator for inequality.

To compare objects of a class and have meaningful results, you must implement special 
methods in your class and call those methods.

A good example of this is the String class. It is possible to have two different String 
objects that represent the same text. If you were to employ the == operator to compare
these objects, however, they would be considered unequal. Although their contents match,
they are not the same object.

#### Determining the Class of an Object

`String name = key.getClass().getName()`

The `getClass() method is defined in the Object class, so it can be called in objects.
It returns a Class object that represents the object's class. That object's getName()
method returns a string holding the name of the class.

Another useful test is the `instanceof` operator, which has two operands: a reference to an objet
on the left, and a class name on the right.

```
boolean check1 "Texas" instance of String;  // true

Point pt = new Point(10,10);
boolean check2 = pt instanceof String;  // false
```

### Summary