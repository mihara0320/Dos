package Dos;

import java.io.IOException;
import java.net.*;

/**
 * Created by kenzi on 11/4/16.
 */
public class PortScan {
    public static void scan(String ip)throws Exception {
        String host = ip;
        InetAddress inetAddress = InetAddress.getByName(host);

        String hostName = inetAddress.getHostName();
        for (int port = 1; port <= 1023; port++) {
            try {
                Socket socket = new Socket(hostName, port);
                String text = hostName + " is listening on port " + port;
                System.out.println(text);
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}