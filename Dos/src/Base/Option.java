package Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class Option{

    /**
     * options HashMap
     *
     * Contains main Options which user can choose
     */
    private static HashMap <Integer, String> options = new HashMap<>();

    /**
     *  loadContents method
     *
     *  Fill up the options HashMap with options
     */
    static void loadContents(){
        setOptions(0, "0: Setup default target");
        setOptions(1, "1: ICMP Flood");
        setOptions(2, "2: SYN Flood");
    }

    /**
     * icmpAttack method
     *
     * Show user what options HashMap contains
     */
    static void showOptions() {

        // Print out big "OPTION" logo
        Greeting.printOption();

        System.out.println();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(getOptions(i));
        }
        System.out.println();
    }

    /**
     * askOption method
     *
     * Ask user to choose a potion out of options HashMap
     *
     * @return user choice
     */
    static String askOption() {

        boolean loop = true;

        // No meaning for the initial value here
        int userChoice = 99999;

        do {

            try {
                Scanner in = new Scanner(System.in);
                System.out.println("*** Select an attack method ***");
                System.out.print("Enter a number: ");
                userChoice = Integer.parseInt(in.nextLine());
            } catch (Exception e){
                System.out.println("Error: Only integer value is accepted! ");
            }

            if (userChoice == 0 || userChoice == 1 || userChoice == 2){
                break;
            } else {
                System.out.println("Error: Select a number from the options" );
                System.out.println();
            }
        } while (loop);

        // Shows user which option is selected
        System.out.println();
        System.out.println("You have selected " + "\"" + options.get(userChoice) + "\"");
        System.out.println();

        String attackMethod = getOptions(userChoice);

        return attackMethod;
    }

    /**
     * exit method
     *
     * Ask user whether finish this program or not
     *
     * @return user choice
     */
    static boolean exit(){

        boolean answer;

        System.out.println();

        if (IsValid.isYesNo("Do you want to exit this program? ")){
            answer = false;
        } else {
            answer = true;
        }
        System.out.println();

        return answer;
    }

    /**
     * showOpenPorts method
     *
     * Ask user whether finish this program or not
     *
     * @param openPorts
     */
    static void showOpenPorts(ArrayList<Integer> openPorts){

        System.out.println("*** Default Target's Open Ports ***");
        System.out.print(Attack.getDefaultTargetIp() + " has ");

        for (int i = 0; i < openPorts.size() ; i++) {
            System.out.print("\"" + openPorts.get(i) + "\"" + " ");
        }

        System.out.println("open!");

    }

    /**
     * setOptions method
     *
     * Just a setter of options
     *
     * @param key value
     */
    static void setOptions(int key, String value){
        options.put(key, value);
    }

    /**
     * getOptions method
     *
     * Just a getter of options
     *
     * @param key value
     */
    static String getOptions(int key){
        return options.get(key);
    }
}