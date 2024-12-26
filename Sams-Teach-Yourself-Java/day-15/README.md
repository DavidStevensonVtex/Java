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

