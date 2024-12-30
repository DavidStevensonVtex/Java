// Listing 17.4 The Full Text of BufferConverter.java

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.* ;

public class BufferConverter {
    public static void main(String[] arguments) {
        try {
            // read data into a byte buffer
            String data = "friends.dat" ;
            FileInputStream inData = new FileInputStream(data);
            FileChannel inChannel = inData.getChannel();
            long inSize = inChannel.size();
            ByteBuffer source = ByteBuffer.allocate( (int) inSize);
            inChannel.read(source, 0);
            source.position(0);
            System.out.println("Original byte data: ");
            for(int i = 0; source.remaining() > 0; i++) {
                System.out.print(source.get() + " ");
            }
            // convert byte data into character data
            source.position(0);
            Charset ascii = Charset.forName("US-ASCII");
            CharsetDecoder toAscii = ascii.newDecoder();
            CharBuffer destination = toAscii.decode(source);
            destination.position(0);
            System.out.println("\n\nNew Character data: ");
            for (int i = 0; destination.remaining() > 0 ; i++) {
                System.out.print(destination.get());
            }
            System.out.println();
        }
        catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

// $ java BufferConverter
// Original byte data: 
// 84 104 101 32 114 97 105 110 32 105 110 32 83 112 97 105 110 32 102 97 108 108 115 32 109 97 105 110 108 121 32 105 110 32 116 104 101 32 112 108 97 105 110 46 10 10 84 104 101 32 114 97 105 110 32 105 110 32 83 112 97 105 110 32 102 97 108 108 115 32 109 97 105 110 108 121 32 105 110 32 116 104 101 32 112 108 97 105 110 46 10 10 84 104 101 32 114 97 105 110 32 105 110 32 83 112 97 105 110 32 102 97 108 108 115 32 109 97 105 110 108 121 32 105 110 32 116 104 101 32 112 108 97 105 110 46 

// New Character data: 
// The rain in Spain falls mainly in the plain.

// The rain in Spain falls mainly in the plain.

// The rain in Spain falls mainly in the plain.