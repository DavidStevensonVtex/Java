// Listing 17.1 The Full Text of WebReader.java

import java.net.*;
import java.io.* ;

public class WebReader {
    void getData(String address) throws MalformedURLException {
        URL page = new URL(address);
        StringBuilder text = new StringBuilder();
        try {
            HttpURLConnection conn = (HttpURLConnection) page.openConnection();
            conn.connect();
            InputStreamReader in = new InputStreamReader( (InputStream) conn.getContent());
            BufferedReader buff = new BufferedReader(in);
            System.out.println("Getting data ...");
            String line ;
            for (line = buff.readLine(); line != null ; line = buff.readLine()) {
                text.append(line);
                text.append("\n");
            }
            System.out.println(text.toString());
        }
        catch( IOException ioe) {
            System.out.println("IO Error: " + ioe.getMessage());
        }
    }

    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java WebReader url");
            System.exit(1);
        }
        try {
            WebReader app = new WebReader();
            app.getData(arguments[0]);
        }
        catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + arguments[0]);
        }
    }
}