package Base;

/**
 * Created by kenzi on 11/14/16.
 */
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

/**
 * Created by kenzi on 11/4/16.
 */
public class PortScan {

    public static ArrayList<Integer> openPorts = new ArrayList<>();

    public static void showOpenPorts(){

        for (int i = 0; i < openPorts.size(); i++) {
            System.out.println(openPorts.get(i) + " is open");
        }
    }

    public static void scan(String ip)throws Exception {


        InetAddress targetIP = InetAddress.getByName(ip); // Converting input string to ip address value

        String targetName = targetIP.getHostName(); // targetName is hostname of target

        for (int port = 1; port <= 1023; port++) { // Loop through all the well know ports

            try {

                Socket socket = new Socket(targetName, port); // Open new socket, syntax used: Socket(String host, int port)

                String message = targetName + " is listening on port " + port;
                System.out.println(message);

                openPorts.add(port); // Adding open port values to openPorts list

                socket.close(); // Close the connection
            } catch (IOException e) {

            }
        }
    }
}