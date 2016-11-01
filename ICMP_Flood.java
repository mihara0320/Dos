package Dos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by kenzi on 11/2/16.
 */
public class ICMP_Flood {

    public static void attack(){

        // Get target IP Address
        Scanner input = new Scanner(System.in);
        System.out.println("What is target IP address?: ");
        String ip = input.nextLine();

        String pingCmd = "ping " + ip;

        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd);

            BufferedReader in = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                String pingResult = inputLine;
            }
            in.close();


        } catch (IOException e) {
            System.out.println(e);
        }
    }
}