# Sams Teach Yourself Java in 21 Days

## Day 15: Working with Input and Output

### Introduction to Streams

Two types of streams:

* byte steams
* character streams

Character streams handle only textual data.

#### Using a Stream

* `java.io`
* `java.nio.file`

* `FileInputStream` - `read()` method returns a byte read from the file
* `BufferedWriter` - `write()` method writes a character to the file
* `close()` method closes a file stream

#### Filtering a Stream

A *filter* is a type of stream that modifies how an existing stream is handled.

The procedure for using a filter on a stream is as follows:

1. Create a stream associated with a data source or data destination.
2. Associate a filter with that stream
3. Read data from or write data to the filter rather than the original stream.

#### Handling Exceptions

Exceptions in the `java.io` package:

* `FileNotFoundException`
* `EOFException`
* The above are subclasses of the `IOException` class

### Byte Streams

All byte streams are a subclass of either `InputStream` or `OutputStream`.

* `FileInputStream` and `FileOutputStream` are byte streams stoerd in files on disk, CD-ROM or other storage devices.
* `DataInputStream` and `DataOutputStream` are filtered byte streams where data such as integers and floating-point numbers can be read.

#### File Streams

File Streams are byte streams.

##### File Input Streams

A file input stream can be created with the `new FileInputStream(String)` constructor.

`FileInputStream fs = new FileInputStream("scores.dat");`

Path references can be indicated in a manner specific to a platform.

`FileInputStream f1 = newFileInputStream("\\data\\calendar.txt");`

This is a Linux example:

`FileInputStream f2 = new FileInputStream("/data/calendar.txt");`

```
char sep = File.separator;
FileInputStream f2 = new FileInputStream(sep + "data" + sep + "calendar.txt");
```

If the method returns -1, which is not a possible byte value, this signifies that the end of the file stream has been reached. (bytes are returned as an integer. Expected values are 0-255 and -1).

To read more than one byte of data: `read(byte[], int, int)`

* A byte array wheret the data will be stored.
* The element inside the array where the data's first byte should be stored
* The number of bytes to read.

```
int newByte = 0;
while (newByte != -1) {
    newByte = diskfile.read();
    System.out.print(newByte + " ");
}
```

##### File Output Streams

A file output stream can be created with the `FileOutputStream(String)` constructor.

You7 can create a file output stream that appends data fter the end of an existing file with
the `FileOutputStream(String, boolean)` constructor.

The file output stream's `write(int)` method is used to write bytes to the stream.

To write more than one byte, you can use the `write(byte[], int, int) method

### Filtering a Stream

Filtered streams are sterams that modify the information sent through an existing stream.

* `FilterInputStream`
* `FilterOutputStream`

#### Byte Filters

Information is delivered more quickly if it can be sent in large chunks, even if those chunks are received faster than they can be handled.

A *buffer* is a storage place where data can be kept before it is needed by a program that reads or writes that data. By using a buffer, you can get data without always going back to the original source of the data.

Buffers are essential when reading extremely large files. Without them, the data from the file could take up all of a Java virtual machine's memory

##### Buffered Streams

* `BufferedInputStream(InputStream)`
* `BufferedInputStream(InputStream, int)`
* `read(byte[], int, int)

* `BufferedOutptuStream(OutputStream)`
* `BufferedOutputStream(OutputStream, int)`
* `write(byte[], int, int)`

##### Console Input Streams

The `System` class, part of the `java.lang` package, has a class variable called `in` that is an InputStream object.

`BufferedInputStream command = new BufferedInputStream(System.in);`

##### Data Streams

The following primitive types can be directly read from or written to a data stream: 
`boolean, byte, double, float, int, long` and `short`.

A data input stream is created the `DataInputStream(InputStream) constructor.

A data output stream requires the `DataOutputStream(OutputStream)` constructor.

* `readBoolean(), writeBoolean(boolean)`
* `readByte(), writebyte(integer)`
* `readDouble(), writeDouble(double)`
* `readFloat(), writeFloat(float)`
* `readInt(), writeInt(int)`
* `readLong(), writeLong(long)`
* `readShort(), writeShort(int)`
* `readUnsignedShort(), writeUnsignedShort(int)`

A data input stream's different read methods do not all return a value that can be used to indicate the end of the stream has been reached.

As an alternative, you c an wait for an EOFException (end-of-file exception) to be thrown when a read method reaches the end of the stream.

### Character Streams

Character streams are used to work with any text represented by the ASCII character set or Unicode, an international character set that includes ASCII.

#### Reading Text Files

* `FileReader` inherits from `InputStreamReader`, which reads a byte stream and convertes the bytes into integer values that represent Unicode characters.

`FileReader look = new FileReader("index.txt");`

* `read()` returns the next character on the stream as an integer
* `read(char[], int, int)` reads characters into the specifed character array with the indicating starting point and the number of characters to read.

```
FileReader text = new FileReader("readme.txt");
int inByte;
do {
    inByte = text.read();
    if (inByte != -1) {
        if (inByte != -1) {
            System.out.print((char) inByte);
        }
    }
}
while (inByte != -1) ;
System.out.println("");
text.close();
```

The `BufferedReader` class reads a character input stream and buffers it for better efficiency. You must have an existing `Reader` object of some kind to create a buffered version.

* `Bufferedread(Reader)`
* `BufferedReader(Reader, int)` - buffer of `size` *int*
