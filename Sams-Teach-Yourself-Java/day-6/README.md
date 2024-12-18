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