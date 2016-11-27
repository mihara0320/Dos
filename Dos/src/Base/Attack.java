package Base;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class Attack {

    private static String defaultTargetIp;
    private static String adhocTargetIp;

    public static ArrayList<Integer> defaultOpenPorts = new ArrayList<>();
    public static ArrayList<Integer> adhocOpenPorts = new ArrayList<>();

    public static ArrayList<Integer> portsToAttack = new ArrayList<>();

    public static boolean defaultTargetSetup;

    /**
     * setPortsToAttack method
     *
     * Ask user which ports to attack
     * Also store the user input in ArrayList "portsToAttack"
     */
    public static void setPortsToAttack(){

        boolean loop = true;

        System.out.println();
        System.out.println("Which open port to attack? [Empty input to finish]");

        while (loop) {

            Scanner input = new Scanner(System.in);
            System.out.print("Enter a open port:");

            String openPortAsString = input.nextLine();

            if (openPortAsString.isEmpty()){
                break;
            }else {

                boolean validInt = IsValid.isInteger(openPortAsString);

                if (validInt) {
                    int openPort = Integer.parseInt(openPortAsString);
                    portsToAttack.add(openPort);

                } else {
                    System.out.println("Error: Only Integer value is allowed");
                }
            }
        }
    }

    /**
     * setDefaultTargetIp method
     *
     * Just a setter of defaultTargetIp
     */
    public static void setDefaultTargetIp(String targetIp) throws IOException {
        defaultTargetIp = targetIp;
    }

    /**
     * setAdhocTargetIp method
     *
     * Just a setter of adhocTargetIp
     */
    public static void setAdhocTargetIp(String targetIp) throws IOException {
        adhocTargetIp = targetIp;
    }

    /**
     * getDefaultTargetIp method
     *
     * Just a getter of defaultTargetIp
     */
    public static String getDefaultTargetIp(){
        String result = defaultTargetIp;
        return result;
    }

    /**
     * getAdhocTargetIp method
     *
     * Just a getter of adhocTargetIp
     */
    public static String getAdhocTargetIp(){
        String result = adhocTargetIp;
        return result;
    }

}

