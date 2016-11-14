package Base;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by masaki on 11/1/2016.
 */
public class Option {
    // Dictionary of options
    static HashMap <Integer, String> options = new HashMap<>();


    // Filling dictionary
    public static void loadContents(){
        options.put(0, "0: ICMP_Flood");
        options.put(1, "1: SYN_Flood");
    }

    // Show all the options available
    public static void showOptions() {
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
    }

    // Let user select an attackLin method
    public static String getOption(){

        Scanner in = new Scanner(System.in);
        System.out.print("Select an attack method(enter a number): ");
        int userChoice = Integer.parseInt(in.nextLine());
        System.out.println();
        System.out.println("OK, you have selected " + options.get(userChoice));
        System.out.println();
        System.out.println();

        String attackMethod = options.get(userChoice);

        return attackMethod;
    }

}