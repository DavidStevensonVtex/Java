// Listing 15.8 the full Text of AllCapsDemo.java

import java.io.*;
import java.nio.file.*;

public class AllCapsDemo {
    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("You must specify a filename as an argument");
            System.exit(-1);
        }
        AllCaps cap = new AllCaps(arguments[0]);
        cap.convert();
    }
}

class AllCaps {
    String sourceName ;

    AllCaps(String sourceArg) {
        sourceName = sourceArg;
    }


    void convert() {
        try {
            // Create file objects
            Path source = FileSystems.getDefault().getPath(sourceName);
            Path temp = FileSystems.getDefault().getPath("tmp_" + sourceName);

            // Create input stream
            FileReader fr = new FileReader(source.toFile());
            BufferedReader in = new BufferedReader(fr);

            // Create output stream
            FileWriter fw = new FileWriter(temp.toFile());
            BufferedWriter out = new BufferedWriter(fw);

            boolean eof = false;
            int inChar;
            do {
                inChar = in.read();
                if (inChar != -1) {
                    char outChar = Character.toUpperCase((char) inChar);
                    out.write(outChar);
                } else {
                    eof = true;
                }
            }
            while (! eof);
            in.close();
            out.close();

            Files.delete(source);
            Files.move(temp, source);
        }
        catch (IOException | SecurityException se) {
            System.out.println("Error -- " + se.toString());
        }
    }
}