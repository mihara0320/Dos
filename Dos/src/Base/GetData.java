package Base;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class GetData {

    /**
     * getIpAddress method
     *
     * Ask user for IpAddress
     * Also checks input validity
     *
     * @return IpAddress
     */
    public static String getIpAddress() throws IOException {

        String confirmedIp = null;

        boolean loop = true;

        do{

            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter an IP Address: ");
                String inputAddress = input.nextLine();

                if (IsValid.isIp(inputAddress)) {
                    confirmedIp = inputAddress;
                    break;
                } else {
                    System.out.println("Error: Entered IP Address is Not Reachable");
                }
            }catch (Exception e){
                System.out.println("Error: Invalid IP Address");
                System.out.println();
            }

        }while (loop);

        return confirmedIp;
    }

    /**
     * getInteger method
     *
     * Ask user for Integer input
     * Also checks input validity
     *
     * @return Integer
     */
    public static int getInteger(){

        int intValue = 0;
        boolean loop = true;

        do {

            Scanner input = new Scanner(System.in);
            System.out.print("Enter an int value: ");
            String userInput = input.nextLine();

            boolean validInt = IsValid.isInteger(userInput);

            if(validInt){
                intValue = Integer.parseInt(userInput);
                break;
            }else{
                System.out.println("Error: Only integer value is allowed");
            }
        }while (loop);

        return intValue;
    }

    /**
     * getDefaultIpAddress method
     *
     * Ask user for IpAddress for DefaultTarget
     * And set DefaultTargetIp value in Attack Class
     *
     * @return IpAddress
     */
    public static String getDefaultTargetIp() throws IOException {

        String inputIp = getIpAddress();
        Attack.setDefaultTargetIp(inputIp);

        return inputIp;
    }

    /**
     * getAdhocIpAddress method
     *
     * Ask user for IpAddress for Adhoc use
     * And set AdhocIpAddress value in Attack Class
     *
     * @return IpAddress
     */
    public static String getAdhocTargetIp() throws IOException {
        String inputIp = getIpAddress();
        Attack.setAdhocTargetIp(inputIp);

        return inputIp;
    }

    /**
     * defaultPortScan method
     *
     * Perform port scan for defaultTarget
     * Also stores port scan result in defaultOpenPorts array in Attack class
     */
    public static void defaultPortScan(String ip)throws Exception {

        System.out.println();
        System.out.println("Scanning ... Open ports ... Scanning ... Only well known ports ... Scanning ... ");
        System.out.println();

        InetAddress targetIp = InetAddress.getByName(ip); // Converting input string to ip address value
        String targetName = targetIp.getHostName(); // targetName is hostname of target

        for (int port = 1; port <= 1023; port++) { // Loop through all the well know ports

            try {

                Socket socket = new Socket(targetName, port); // Open new socket, syntax used: Socket(String host, int port)

                String message = targetName + " is listening on port: " + port;
                System.out.println(message);

                Attack.defaultOpenPorts.add(port); // Adding open port values to openPorts list
                socket.close(); // Close the connection

            } catch (IOException e) {

            }
        }

        System.out.println();
    }

    /**
     * adhocPortScan method
     *
     * Perform port scan for adhocTarget
     * Also stores port scan result in adhocOpenPorts array in Attack class
     */
    public static void adhocPortScan(String ip)throws Exception {

        InetAddress targetIp = InetAddress.getByName(ip); // Converting input string to ip address value
        String targetName = targetIp.getHostName(); // targetName is hostname of target

        for (int port = 1; port <= 1023; port++) { // Loop through all the well know ports

            try {

                Socket socket = new Socket(targetName, port); // Open new socket, syntax used: Socket(String host, int port)

                String message = targetName + " is listening on port: " + port;
                System.out.println(message);

                Attack.adhocOpenPorts.add(port); // Adding open port values to openPorts list
                socket.close(); // Close the connection

            } catch (IOException e) {

            }
        }
    }

    /**
     * defaultTargetSetup method
     *
     * Call getDefaultTargetIp(), and defaultPortScan()
     * Also leave a mark that says user set up defaultTarget
     */
    public static void defaultTargetSetup() throws Exception {

        getDefaultTargetIp();
        defaultPortScan(Attack.getDefaultTargetIp());
        Attack.defaultTargetSetup = true;
        System.out.println();
        System.out.println("Default target setup completed!!!");

    }

    /**
     * getPortsToAttack method
     *
     * Ask user which ports to attack
     *
     * @return ArrayList<Integer> contains attack ports
     */
    public static ArrayList<Integer> getPortsToAttack(){

        ArrayList<Integer> openPorts = new ArrayList<>();

        boolean loop = true;

        System.out.println();
        System.out.println("Which open port to attack? [Empty input to finish]");

        while (loop) {

            Scanner input = new Scanner(System.in);
            System.out.print("Enter a open port:");

            String openPortAsString = input.nextLine();

            if (openPortAsString.isEmpty()){
                break;
            }else {

                boolean validInt = IsValid.isInteger(openPortAsString);

                if (validInt) {
                    int openPort = Integer.parseInt(openPortAsString);
                    openPorts.add(openPort);

                } else {
                    System.out.println("Error: Only Integer value is allowed");
                }
            }
        }

        return openPorts;

    }

}
