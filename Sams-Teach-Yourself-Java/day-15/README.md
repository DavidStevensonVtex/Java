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
