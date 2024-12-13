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

Each isntance can change the values of those instance variables without 
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