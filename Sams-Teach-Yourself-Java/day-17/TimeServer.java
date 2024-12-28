// Listing 17.3 The Full Text of TimeServer.java

import java.io.* ;
import java.net.* ;
import java.util.*;

public class TimeServer extends Thread {
    private ServerSocket sock ;

    public TimeServer() {
        super();
        try {
            sock = new ServerSocket(4415);
            System.out.println("TimeServer running ...");
        }
        catch (IOException e) {
            System.out.println("Error: couldn't create socket.");
            System.exit(1);
        }
    }

    public void run() {
        Socket client = null;

        while (true) {
            if (sock == null) 
                return;
            
            try {
                client = sock.accept();
                BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
                PrintWriter os = new PrintWriter(bos, false);
                // String outLine ;
                Date now = new Date();
                os.println(now);
                os.flush();
                os.close();
                client.close();
            }
            catch (IOException e) {
                System.out.println("Error: couldn't connect to client.");
                System.exit(1);
            }
        }
    }

    public static void main(String[] arguments) {
        TimeServer server = new TimeServer();
        server.start();
    }
}

// $ java TimeServer
// TimeServer running ...


// On a different terminal session:
// $ telnet
// telnet> open localhost 4415
// Trying 127.0.0.1...
// Connected to localhost.
// Escape character is '^]'.
// Sat Dec 28 15:53:11 EST 2024
// Connection closed by foreign host.