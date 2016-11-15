package Base;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kenzi on 11/14/16.
 */
public class TargetData {

    public static String defaultTargetIp;
    public static String adhocTargetIp;

    public static ArrayList<Integer> defaultOpenPorts = new ArrayList<>();
    public static ArrayList<Integer> adhocOpenPorts = new ArrayList<>();

    public static void showOpenPorts(ArrayList<Integer> portList){

        for (int i = 0; i < portList.size(); i++) {
            System.out.println(portList.get(i) + " is open");
        }
    }

    public static String getIpAddress() throws IOException {

        String confirmedIp = null;

        boolean loop = true;

        do{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter an IP Address: ");
            String inputAddress = input.nextLine();

            if (validIp(inputAddress)) {
                confirmedIp = inputAddress;
                break;
            } else {
                System.out.println("Error: Invalid IP Address");
            }
        }while (loop);

        return confirmedIp;
    }


    public static boolean validIp(String ip) throws IOException {

        String testIp = ip;
        int timeOut = 3000;

        boolean status = InetAddress.getByName(testIp).isReachable(timeOut);

        return status;
    }

    public static int getIntValue(){
        
        int intValue = 0;
        boolean loop = true;
        
        do {

            Scanner input = new Scanner(System.in);
            System.out.print("Enter an int value: ");
            String userInput = input.nextLine();
            
            boolean validInt = isInteger(userInput);
            
            if(validInt){
                intValue = Integer.parseInt(userInput);
                break;
            }else{
                System.out.println("Error: Only integer value is allowed");
            }
        }while (loop);
        
        return intValue;
    }
    
    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try
        {
            Integer.parseInt(s);
            isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
            // s is not an integer
        }

        return isValidInteger;
    }

}
