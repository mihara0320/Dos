package Dos;

import java.util.Scanner;

/**
 * Created by kenzi on 11/3/16.
 */
public class IpAddress {

    public static String targetIp;

    public static String getIP(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is target IP address?: ");
        String ip = input.nextLine();
        targetIp = ip;

        return ip;
    }
}
