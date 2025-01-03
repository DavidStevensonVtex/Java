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

#### BitSets

The `BitSet` class is useful when you need to represent a large amount of binary data - bit values that equal either 0 or 1.

```
class ConnectionAttributes {
    public static final int READABLE = 0;
    public static final int WRITABLE = 1;
    public static final int STREAMABLE = 2;
    public static final int FLEXIBLE = 3 ;
}
```

```
// BitSet connex = new BitSet();
BitSet connex = new BitSet(4);

connex.set(ConnectionAttributes.WRITABLE);
connex.set(ConnectionAttributes.STREAMABLE);
connex.set(ConnectionAttributes.FLEXIBLE);

connex.clear(ConnectionAttributes.WRITABLE);

boolean isWriteable = connex.get(ConnectionAttributes.WRITABLE);
```

#### ArrayLists

The `ArrayList` class implements and expandible and contractible array of objects.

```
ArrayList golfer = new ArrayList();
ArrayList golfer = new ArrayList(30);

golfer.add("Tseng");
golfer.add("Lewis");
golfer.add("Stanford");

String s1 = (String) golfer.get(0);
String s2 = (String) golfer.get(2);

golfer.add(1, "Myazato);
golfer.add(0, "Kerr");
golfer.remove(3);

golfer.clear();

boolean isThere = golfer.contains("Webb");

int i = golfer.indexOf("Stanford");

golfer.remove("Kung");

int size = golfer.size();
```

The Java Class LIbrary also includes `Vector`, a data structure that works a lot like array lists.
`Vector` is obsolete.

#### Looping Throw Data Structures

```
Iterator it = golfer.iterator();

for (Iterator i = golfer.iterator(); i.hasNext(); ) {
    String name = (String) i.next();
    System.out.println(name);
}
```

#### Stacks

The `Stack` class in Java is implemented as a last-in, first-out stack, which means that the last item to be added to the stack is the first one to be removed.

```
Stack s = new Stack();
s.push("One");
s.push("Two");
s.push("Three");
s.push("Four");
s.push("Five");
s.push("Six");

String s1 = (String) s.pop();
String s2 = (String) s.pop();

String s3 = (String) s.peek();

int i = s.search("Two");

boolean isEmpty = s.empty();
```

#### Map

The `Map` interface defines a framework for implementing a key-mapped data structure, a place to store objects each referenced by a key.

```
Rectangle r1 = new Rectangle(0, 0, 5, 5);
look.put("small", r1);
Rectangle r2 = new Rectangle(0, 0, 15, 15);
look.put("medium", r2);
Rectangle r3 = new Rectangle(0, 0, 25, 25);
look.put("large", r3);

Rectangle r = (Rectangle) look.get("medium");

look.remove("large");

int size = look.size();

boolean isEmpty = look.isEmpty();
```

#### Hash Maps

The `HashMap` class implements the `Map` interface and provides a complete implementation of a key-mapped data structure.

```
HashMap hash = new HashMap(20);

HashMap = new HashMap(20, 0.5F);    // Second parameter is load factor

hash.clear();

Rectangle box = new Rectangle(0, 0, 5, 5);
boolean isThere = hash.containsValue(box);

boolean isThere = hash.containsKey("Small");
```

The parent of all classes, Object, defines a hashCode() method overridden in most standard Java classes.
Any class that defines a `hashCode()` method can be efficiently sotred and accessed in a hash map.
A class that wants to be hashed must also implement the `equals()` method, which defines a way of telling whether two objects are equal. The `equals()` method usually just performs a straight comparison of all the member variables defined in a class.

#### Generics

When a data structure works with any kind of object, the Java compiler can't display a warning when the structure is being misused.

You can specify the class or classes expected in a data structure using a feature of the language called *generics*.

`ArrayList<Integer> zipCodes = new ArrayList<>();`

`HashMap<String, Float> quality = new HashMap<>();`

Generics make it easier to retrieve an object from a data structure because you don't have to use casting to convert them to the desired class.
