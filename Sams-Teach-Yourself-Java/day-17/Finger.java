// Listing 17.2 The Full Text of Finger.java

import java.io.*;
import java.net.*;
import java.util.*;

public class Finger {
    public static void main (String[] arguments) {
        String user;
        String host;
        if ((arguments.length == 1) && (arguments[0].indexOf("@") > -1)) {
            StringTokenizer split = new StringTokenizer(arguments[0], "@");
            user = split.nextToken();
            host = split.nextToken();
        } else {
            System.out.println("Usage: java Finger user@host");
            return;
        }

        try (Socket digit = new Socket(host, 79);
            BufferedReader in = new BufferedReader(new InputStreamReader(digit.getInputStream()));
        ) {

            digit.setSoTimeout(20000);
            PrintStream out = new PrintStream(digit.getOutputStream()) ;
            out.print(user + "\015\012");

            boolean eof = false ;
            while (!eof) {
                String line = in.readLine();
                if (line != null) {
                    System.out.println(line);
                } else {
                    eof = true;
                }
            }
        }
        catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}

// $ java Finger icculus@icculus.org
// IcculusPlan


// It took literally years, but SDL3 has hit ABI lock!

// We will still add to the API, but no more _removing_ or _changing_ it.

// So while we're still zooming towards an official release, it's now safe
// to migrate your games from SDL2!

// [Here's the official announcement][1], and you're going to want to drool
// a little while reading up on [the new features][2].

// Not ready to migrate? No problem, we have [sdl2-compat][3] ready to go,
// so you can drop it into your SDL2-based program and be powered by SDL3
// behind the scenes.

// More fun stuff coming soon!

//   [1]: https://github.com/libsdl-org/SDL/releases/tag/preview-3.1.3
//   [2]: https://wiki.libsdl.org/SDL3/NewFeatures
//   [3]: https://github.com/libsdl-org/sdl2-compat

// --ryan.

// ---------------------------------------------------------------------
// When this .plan was written: 2024-10-04 23:21:21
// .plan archives for this user: finger icculus?listarchives=1@icculus.org
// Powered by IcculusFinger v2.1.27 (https://icculus.org/IcculusFinger/)
// Stick it in the camel and go.