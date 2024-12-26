// Listing 15.2 The Full Text of ByteWriter.java

import java.io.*;

public class ByteWriter {
    public static  void main(String[] arguments) {
        int data[] = new int[299];
        for (int i = 0 ; i < data.length ; i++) {
            data[i] = i % 255;
        }

        try (FileOutputStream file = new FileOutputStream("data.dat")) {
            for (int i = 0 ; i < data.length ; i++ ) {
                file.write(data[i]);
            }
        }
        catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}
