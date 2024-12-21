# Sams Teach Yourself Java in 21 Days

## Day 8: Data Structures

* Bit sets, which hold boolean values
* Array lists, arrays that can grow and shrink in size
* Stacks, structures stored in last-in first-out (LIFO) order
* Hash maps, which store items using keys

### Moving Beyond Arrays

The Java class library provides a set of data structures in the java.util package that gives you more flexibility in organizing and manipulating data.

### Java Structures

The data structures provide by the java.util package perform a wide range of functions.

* BitSet
* ArrayList
* Stack
* HashMap

The `Iterator` interface itself isn't a data structure, but it defines a means to retrieve success elements from a data structure.

* next()

The `BitSet` class implements a group of bits, or flags, which can be set and cleared individually.

The `ArrayList` class can grow as necessary to accommondate new elements and also shrink.

The `Stack` class implements a last-in, first-out stack of elements.

The `HashMap` class implements `Dictionary`, an abstract class that defines a data structure form mapping keys to values. This provides an implementation of a key-mapped data structure.

#### Iterator

* public boolean hasNext();
* public Object next();
* public void remove();

```
while (users.hasNext()) {
    Object ob = users.next();
    System.out.println();
}
```