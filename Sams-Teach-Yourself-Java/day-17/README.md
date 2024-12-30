# Sams Teach Yourself Java in 21 Days

## Day 17: Communicating Across the Internet

The `java.net` package makes it possible to communicate over a network, providing cross-platform abstractions to make connections, transfer files using common web protocols, and create sockets.

The `java.nio` package expands Java's input and output classes.

### Networking in Java

Javas basic networking is supported by classes in the java.net package, including support for connecting and retrieving files through the Hypertext Transfer Protocol (HTTP), File Transfer Protocol (FTP), as well as working a a lower level with sockets.

* `Socket` and `ServerSocket` classes.
* `inputStream()` a method that opens a connection to a URL and can extract data from that connection.

#### Opening a Stream Over the Net

Document types on the web:

* HTML
* XML
* Plain-text

To load a document off of the web:

1. Create a URL object that represents the resource's web address.
2. Create an HttpURLConnection object that can load the URL and make a connection to the site hosting it.
3. Use the `getContent()` method of that HttpURLConnection object to create an InputStreamReader that can read a stream of data from the URL.
4. Use that input stream reader to create a `BufferedReader` object that can efficiently read characters from an input stream.

URL is an acronym for *uniform resource locator*.

URL is part of the `java.net` package.

* URL (String)
* URL (URL, String) creates a URL object with a base address providedby the specified URL and a relative path provide by the String.
* URL(String, String, int, String) creates a new URL object from a protocol (such as "http" or "ftp"), hostname (such as "www.cnn.com" or "web.archive.org"), port number(80 for HTTP), and filename or pathname.
* URL(String, String, String) same as the previous constructor minus the port number.

```
try {
    URL load = new URL("http://www.samspublishing.com");
} catch (MalformedURLException e) {
    System.out.println("Bad URL");
}
```

`HttpUrlConnection` class methods:

* getHeaderFile(int)
* getHeaderFieldKey(int)
* getResponseCode()
* getResponseMessage()
* getContentType()
* setFollowRedirects(boolean)

#### Sockets

Java provides the `Socket` and `SererSocket` classes as an abstraction of standard Transmission Control Protocol (TCP) socket programming techniques.

```
Socket connection = new Socket(hostname, portNumber);
connection.setSotimeOut(50000);
```

If you don't set a time-out in a program that uses sockets, it might hang indefinitely, waiting for data.

```
BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
DataInputStream in = new DataInputStream(bis);

BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
DataOutputStream out = new DataOutputStream(bos);
```

```
DataInputStream in = new DataInputStream(new BufferedInputSteram(sock.getInputStream()));
connection.close();
```

Socket programming can be used for many services delivered using TCP/IP networkign, including telnet, Simple Mail Transfer Protocol (SMTP) for incoming mail, Network News Transfer Protocol for Usenet news, and finger.

The last of these, finger, is a protocol for asking a system about one of its users. By setting up a finger server, a system administrator enables an Internet-connected machine to answer requests for user information. finger has fallen into disuse because of security concerns.


#### Socket Servers

Server-side sockets work simiilarly to client sockets, with the exception of the accept() method.
A server socket listens on a TCP port for a connection from a client; when a client connects to that
port, the `accept()` method accepts a connection from that client.
By using both client and server sockets, you can create applications that communicate with each other over the network.

`ServerSocket servo = new ServerSocket(8888);`

Hse tbe `accept()`  method to listen on that port (and to accept a connection from any clients if one is made):

`servo.accept()`

To extend the behavior of the socket classes -- for example to allow network connectiosn to work accross a firewall or proxy -- you can use the abstract class `SocketImpl` and the interface `SocketImplFactory` to create a new transport-layer socket implementation.

The problem with this mechanism is that although it works for simple cases, it prevents you from adding other protocols on top of TCP and from having multiple socket implementatiosn for each Java runtime.

Because the `Socket` and `ServerSocket` classes are not final, you can create subclasses of these classes that use either the default socket implementation or your own implementation. This allows much more flexible network capabilities.

##### Designing a Server Application

Port 4415 was chosen arbitrarily for this project, but it could be any number from 1024 to 65,535.

### The `java.nio` Package

Two related packages:

* java.nio.channels
* java.nio.charset

#### Buffers

Buffers are objects that represent data streams stored in memory.

Buffers often are used to improve the performance of programs that read input or write output. They enable a program to put a lot of data in memory, where it can be read, writen, and modified more quickly.

* ByteBuffer
* CharBuffer
* DoubleBuffer
* FloatBuffer
* IntBuffer
* LongBuffer
* ShortBuffer

```
int[] temperatures = { 90, 85, 87, 78, 80, 75, 70, 79, 85, 92, 99 };
IntBuffer tempBuffer = IntBuffer.wrap(temperatures);
for (int i = 0; tempBuffer.remaining() > 0 ; i++ )
    System.out.println(tempBuffer.get());
```

Another way to create a buffer is to set up an empty buffer and then put data in it.
To create the buffer, call the static method `allocate(int)` of the desired buffer c lass with the size of the buffer as an argument.

* put(int)
* put(int, int) - stores an integer (second arg) at a specific position in the buffer (first arg)
* put(int[])
* put(int[], int, int)
* put(IntBuffer)


Call the `position(int)` method to change the position tot he argument specified as an integer.

Another important position to track when using buffers is the limit -- thelast place in the buffer that contains data.

It isn't necessary to figure out the limit when the buffer is always full; in that case, you know the buffer's last position has something in it.

```
int[] temps = { 90, 85, 87, 78, 80, 75, 70, 79, 85, 92, 99 };
IntBuffer tempBuffer = IntBuffer.allocate(temps.length);
for (int i = 0; i < temps.length ; i++) {
    float celsius = ((float) temps[i] - 32) / 9 * 5;
    tempBuffer.put((Int) celsius);
}

tempBuffer.position(0);
for ( int i = 0 ; tempBuffer.remaining() > 0 ; i++ ) {
    System.out.println(tempBuffer.get());
}
```

#### Byte Buffers

* putChar(char) - stores 2 bytes
* putDouble(double) - stores 8 bytes
* putFloat(float) - stoers 4 bytes
* putInt(int) - stores 4 bytes
* putLong(long) - stores 8 bytes
* putShort(short) - stores 2 bytes

* getChar()
* getDouble()
* getFloat()
* getInt()
* getLong()
* getShort()

#### Character Sets

Character sets are a set of clases used to convert between byte buffers and character buffers.

* CharSet - Unicode character set
* CharSetDecoder - transforms a series of bytes into a series of characters
* CharsetEncoder - transforms a set of characters into a series of bytes

Java support six character encodings:

* US-ASCII
* ISO-8859-1 256-character ISO Latin Alphabet No. 1
* UTF-8 
* UTF-16BE - Unicode Big Endian
* UTF-16LE - Unicode Little Endian
* UTF-16 - Unicode - 16 bit characters, using an optional byte-order mark

```
Charset isoset = Charset.forName("ISO-8859-1");
CharsetDecoder decoder = set.newDecoder();
netBuffer.position(0)
CharBuffer netText = decoder.decode(netBuffer);
```

#### Channels

A common use for a buffer is to associate it with an input or output stream. You can fill a buffer with data from an input stream or write a buffer to an output stream.

To do this, you must use a channel -- an object that connects a buffer to the stream.
Channels are part of the `java.nio.channels` package.

You can associate channels with a stream by calling the getChannel() method available in some of the stream classes in the java.io package.

The `FileInputStream` and `FileOutputStream` classes have getChannel() methods that return a FileChannel object. This file channel can be used to read, write, and modify the data in the file.

After you have created the file channel, you can find out how many bytes the file contains by calling its size() method. This is necessary if you want to create a byte buffer to hold the file's contents.

```
try {
    Sting source = "prices.dat";
    FileInputStream inSource = new FileInputStream(source);
    FileChannel inChannel = inSource.getChannel();

    long inSize = inChannel.size();
    ByteBuffer data = ByteBuffer.allocate( (int) inSize);
    inChannel.read(data, 0);
    data.position(0);
    for (int i = 0 ; data.remaining() > 0; i++ ) {
        System.out.print(data.get() + " ");
    }
}
catch (FileNotFoundException fne) {
    System.out.println(fne.getMessage())
}
```

##### Network Channels

A popular fearture of the java.nio package is its support for nonblocking input and output over a networking connection.

In Java, blocking refers to a statement that must complete execution before anything else happens in the program.

Connections can be broken. A server could go offline. A socket connection could appear to be stalled because a blocked statement is waiting for something to happen.

With the java.nio package, you can create networking c onnections and read to and write from them using non-blocking methods.

* Associate a socket channel with an input or output stream.
* Configure the channel to recognize the kind of networking events you want to monitor, such as new connections, attempts to read data over the chanell, and attempts to write data.
* Call a method to open the channel.
* Because the method is nonblocking, the program continues executing so that you can handle other tasks.
* If one of the networkign events you are monitoring takes place, your program is notified - a method associated with the event is called.

To use nonblocking input and output, you must work with channels instead of streams.

###### Nonblocking Socket Clients and Servers

1. Create an object that repesents the Internet address to which you are connecting. java.net.InetSocketAddress
2. InetSocketAddress(string hostName, int portNumber)
3. Alternatively, if server is identified by its IP address: InetAddress.getByName(String ipAddress)
4. Nonblocking connections require a socket channels. java.nio.SocketChannel
5. A socket channel can be configured for blocking or nonblocking communication. channel.configureBlocking(boolean)
6. channel.connect(InetSocketAddress)
7. On a blocking channel, the connect() method attempts to establist a connection to the server and waits for it to complete.
8. On a nonblocking channel, the connect() method returns immediately with a value of false. You must use a channel-listeing object called a Selector. A Selector is an object that keeps track of things that happen to a docket channel (or another channel in the package that is a subclass of SelectableChannel).
9. To create a selector, call its open() method: `Selector monitor = Selector.open();`
10. When you use a Selector, you must indicate the events you want to monitor. channel.register(Selector, int, Object)
    a. The int value represents the events being monitored.
    b. An Object that can be delivered along with the key, or null otherwise.

```
Selector spy = Selector.open();
channel.register(spy, SelectionKey.OP_READ, null);
```

```
Selector spy = Selector.open();
channel.register(spy, SelectionKey.OP_READ + SelectionKey.OP_WRITE, null);
```

You wait for events by calling the selector's select() or select(long) methods.

