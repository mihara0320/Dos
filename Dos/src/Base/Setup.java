package Base;

import java.io.IOException;
import java.net.*;

/**
 * Created by kenzi on 11/4/16.
 */

public class Setup extends TargetData {

    public static String getDefaultTargetIp() throws IOException {
        String inputIp = getIpAddress();
        defaultTargetIp = inputIp;

        return inputIp;
    }


    public static String getAdhocTargetIp() throws IOException {
        String inputIp = getIpAddress();
        adhocTargetIp = inputIp;

        return inputIp;
    }

    public static void defaultPortScan(String ip)throws Exception {

        InetAddress targetIp = InetAddress.getByName(ip); // Converting input string to ip address value
        String targetName = targetIp.getHostName(); // targetName is hostname of target

        for (int port = 1; port <= 1023; port++) { // Loop through all the well know ports

            try {

                Socket socket = new Socket(targetName, port); // Open new socket, syntax used: Socket(String host, int port)

                String message = targetName + " is listening on port " + port;
                System.out.println(message);

                defaultOpenPorts.add(port); // Adding open port values to openPorts list
                socket.close(); // Close the connection

            } catch (IOException e) {

            }
        }
    }

    public static void adhocPortScan(String ip)throws Exception {

        InetAddress targetIp = InetAddress.getByName(ip); // Converting input string to ip address value
        String targetName = targetIp.getHostName(); // targetName is hostname of target

        for (int port = 1; port <= 1023; port++) { // Loop through all the well know ports

            try {

                Socket socket = new Socket(targetName, port); // Open new socket, syntax used: Socket(String host, int port)

                String message = targetName + " is listening on port " + port;
                System.out.println(message);

                adhocOpenPorts.add(port); // Adding open port values to openPorts list
                socket.close(); // Close the connection

            } catch (IOException e) {

            }
        }
    }
}