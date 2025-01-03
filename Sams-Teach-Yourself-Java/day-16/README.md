# Sams Teach Yourself Java in 21 Days

## Day 16: Serializing and Examining Objects

* Object serialization, the ability to read and write an object using streams
* Reflection, in which one object can learn details about another object

### Object Serialization

A *stream* is an object that carries data from one place to another.

Two types of streams were introduced during Day 15:

* Byte streams
* Character streams

A third type of stream, an *object stream*, makes it possible for data to be represented as objects rather than as some external form.

Object streams, such as byte and character streams, are part of the `java.io` package.

For an object to be saved to a destination such as a disk fiel, it must be converted to serial form.

When you implement the `Serializable` interface, an object indicates that it can be used with streams.
This interface does not contain any methods that must be included in the classes that implement it.
The sole purpose of the `Serializable` interface is to indicate that objects can be stored and 
retrieved in serial form.

A programming concept involved in object serialization is *persistence* - an object's capability to exist and function outside the program that created it.

When several objects contain references to the same object, Java automatically ensures that only one copy of that object is serialized.

Some of the object's variables can be omitted from serialization using the `transient` modifier.

#### Object Output Streams

An object is written to a stream via the `ObjectOutputStream` class.

An object output stream is created with the `ObjectOutputStream(OutputStream)` constructor.

```
FileOutputStream disk = new FileOutputStream("SavedObject.dat");
ObjectOutputStream disko = new ObjectOutputStream(disk);
disko.writeObject(userData);
```

Methods:

* `write(int)`
* `write(byte[])`
* `write(byte[], int, int)`
* `writeBoolean(boolean)`
* `writeByte(int)`
* `writeBytes(String)`
* `writeChar(int)`
* `writeChars(String)`
* `writeDouble(double)`
* `writeFloat(float)`
* `writeInt(int)`
* `writeLong(long)`
* `writeShort(short)`

The `ObjectOutputStream` can throw `IOException` errors.

#### Object Input Streams

An object is read from a stream using the `ObjectInputStream` class.

An object input stream is created with the `ObjectInputStream(InputStream)` constructor.
This constructor throws four exceptiosn: IOException, StreamCorruptionException, SecurityException, and NullPointerException.

```
try {
    FileInputStream disk = new FileInputStream("SavedObject.dat");
    ObjectInputStream obj = new ObjectInputStream(disk);
    WorkData dd = (WorkData) disk.readObject();
}
catch (IOException ie) {
    System.out.println("IO error -- " + ie.toString());
}
```

The `readObject()`method can throw IOException, OptionalDataException, ClassNotFoundException, and InvalidClassException errors.

FileInputStream methods:

* read()
* read(byte[], int, int)
* readBoolean()
* readByte()
* readChar()
* readDouble()
* readFloat()
* readInt()
* readLine()
* readLong()
* readShort()
* readUnsignedByte()
* readUnsignedShort()

Each of these methods throws an `IOException` if an input/output error occurs as the stream is being read.

#### Transient Variables

When you create an object that can be serialized, one design consideration is whether all the object's instance variables should be saved.

It's a good idea to exclude from serialization a variable that contains sensitive information, like passwords.

A third reason not to serialize a variable is to save space on the storage file that holds the object.

To prevent an instance variable from being included in serialization, the `transient` modifer is used.

`public transient int limit = 55;`

#### Checking an Object's Serialized Fields

An important thing to consider when serializing objects is how easily a malicious programmer could tamper with an object in serial form.

When you re-create an object from its serial form, you can't rely on a constructor method to ensure that its fields have permissible values.

Instead, if you want to check that an object read from a stream contains acceptable values, the object can include a `readObject(ObjectInputStream)` method.

This method throws `IOException` and `ClassNotFoundException` errors and takes the following form:

```
private void readObject(ObjectInputStream ois) {
    ois.defaultReadObject();
}
```

Note that it is `private`.

The following method could be added to the Message class to reject a serialized object that has an empty from value:

```
private void readObject(ObjectInputStream ois) 
    throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    if (from.length() < 1) {
        throw new IOException("Null sender in message.");
    }
}
```

### Inspecting Classes and Methods with Reflection

Every object in Java inherits the `getClass()` method, which identifies that object's class or interface.

```
Class keyClass = key.getClass();
String keyName = keyClass.getName();
```

These featuers are part of Java's support for reflection, a technique that enables one Java class - such as a program you write - to learn details about another class.

One use of reflection is to determine a serialized object's class when it is read.

#### Inspecting and Creating Classes

The `Class` class, which is part of the `java.lang` package, is used to learn about and create classes, interfaces, and even primitive types.

In addition to using `getClass()`, you can create `Class` objects by appending .class to the name of a class, interface, or primitive type, as in the following examples.

```
Class keyClass = KeyClass.class ;
Class thr = Throwable.class;
Class floater = float.class;
Class floatArray = float[].class;
```

You also can create `Class` objects by using the `forName() class method with a single argument: a string containing the name of an existing class.

`Class lab = Class.forName("javax.swing.JLabel");`

The `forName()` method throws a `ClassNotFoundException` if the specified class cannot be found.

Class objects that represent arrays are handled a little differently when `getName()` is called on them.

You can also use the `Class` class to create new objects using the `newInstance() method.

`Throwable thr2 = (Throwable) thr.newInstance()`

The `newInstance()` method throws several kinds of exceptions:

* IllegalAccessException
* InstantiationException - You cannot create a new object because the class is abstract.
* SecurityException

#### Working with Each Part of a Class

Although `Class` is part of the `java.lang` package, the primary support for reflection is the `java.lang.reflect` package, which includes the following classes:

* Field
* Method
* Constructor
* Array
* Modifer

Each of these reflectin classes has methods for workign with an element of a class.

The `Method` class has several useful instance methods:

* getParameterTypes()
* getReturnType()
* getModifiers()

```
int mods = current.getModifiers();
System.out.println(Modifier.toString(mods));
```

The `Constructor` clas:

* getModifiers()
* getName()

For example, if there is a KeyClass(String, int) constructor:

```
Class kc = KeyClass.class;
Class[] cons = new Class[2];
cons[0] = String.class;
cons[1] = int.class;
Constructor c = kc.getConstructor(cons);
```

The `getConstructor(Class[])` method throws a `NoSuchMethodException` if there isn't a constructor with arguments that match the `Class[]` array.

#### Inspecting a Class