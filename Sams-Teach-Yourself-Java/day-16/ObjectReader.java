// Listing 16.2 The Full Text of ObjectReader.java

import java.io.*;
import java.util.*;

public class ObjectReader {
    public static void main(String[] arguments) {
        try (
            FileInputStream fi = new FileInputStream("Message.obj");
            ObjectInputStream oi = new ObjectInputStream(fi);
        ) {
            Message mess = (Message) oi.readObject();
            System.out.println("Message:\n");
            System.out.println("From: " + mess.from);
            System.out.println("To: " + mess.to);
            System.out.println("Date: " + mess.when + "\n");
            for (int i = 0 ; i < mess.lineCount ; i++ ) {
                System.out.println(mess.text[i]);
            }
        }
        catch (Exception e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}

// $ java ObjectReader
// Message:

// From: Sam Wainwright, London
// To: George Bailey, Bedford Falls
// Date: Fri Dec 27 09:37:51 EST 2024

// Mr. Gower cabled you need cash. Stop.
// My office isntructed to advance you up to twenty-five
// thousand dollars. Stop. Hee-haw and Merry Christmas.