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
