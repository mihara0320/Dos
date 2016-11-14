package Base;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
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
        System.out.println();
        System.out.println();

        targetIp = ip;

        return ip;
    }

    public static String getRandomStringIp(){

        Random r = new Random();

        String first = Integer.toString(r.nextInt(256));
        String second = Integer.toString(r.nextInt(256));
        String third = Integer.toString(r.nextInt(256));
        String fourth = Integer.toString(r.nextInt(256));

        String generatedIp = first +"."+ second +"."+ third +"."+ fourth;
        System.out.println(generatedIp);

        return generatedIp;
    }

    public static InetAddress getRandomIpInet() throws UnknownHostException {

        Random r = new Random();

        String first = Integer.toString(r.nextInt(256));
        String second = Integer.toString(r.nextInt(256));
        String third = Integer.toString(r.nextInt(256));
        String fourth = Integer.toString(r.nextInt(256));

        String generatedIpString = first +"."+ second +"."+ third +"."+ fourth;

        InetAddress generatedIp = InetAddress.getByName(generatedIpString);

        return generatedIp;
    }


}
