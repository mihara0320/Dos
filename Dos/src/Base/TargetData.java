package Base;

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

    public static String getIpAddress(){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an IP Address: ");
        String inputAddress = input.nextLine();

        return inputAddress;
    }

    public static void showOpenPorts(ArrayList<Integer> portList){

        for (int i = 0; i < portList.size(); i++) {
            System.out.println(portList.get(i) + " is open");
        }
    }

}
