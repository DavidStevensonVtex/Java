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