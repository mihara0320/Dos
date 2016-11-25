package Base;

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
     * Contains main printOption that user can choose
     */
    static HashMap <Integer, String> options = new HashMap<>();

    /**
     *  loadContents method
     *
     *  Fill up the options HashMap with options
     */
    public static void loadContents(){
        options.put(0, "0: Setup default target");
        options.put(1, "1: ICMP Flood");
        options.put(2, "2: SYN Flood");
    }

    /**
     * icmpAttack method
     *
     * Show user what options HashMap contains
     */
    public static void showOptions() {

        Greeting.printOption();
        System.out.println();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
        System.out.println();
    }

    /**
     * getOption method
     *
     * Ask user to choose a potion out of options HashMap
     *
     * @return user choice
     */
    public static String getOption() {

        boolean loop = true;

        int userChoice = 10;

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

        System.out.println();
        System.out.println("You have selected " + "\"" + options.get(userChoice) + "\"");
        System.out.println();


        String attackMethod = options.get(userChoice);

        return attackMethod;
    }

    /**
     * askYesNo method
     *
     * Get only Yes or No user answer
     * Also verifies if the answer is legitimate or not
     *
     * @return Yes or No answer
     */
    public static boolean askYesNo(String question){
        boolean choice = true;

        boolean loop = true;

        do {
            Scanner input = new Scanner(System.in);
            System.out.print(question + " [yes/no]: ");
            String answer = input.nextLine();

            if (answer.equals("yes") || answer.equals("YES") || answer.equals("y") ){
                choice = true;
                break;
            } else if (answer.equals("no") || answer.equals("NO") || answer.equals("n")){
                choice = false;
                break;
            } else {
                System.out.println("Error: Only \"yes\" or \"no\" allowed! " );
            }
        } while (loop);

        return choice;
    }

    /**
     * exit method
     *
     * Ask user whether finish this program or not
     *
     * @return user choice
     */
    public static boolean exit(){

        boolean answer;

        System.out.println();

        if (askYesNo("Select another printOption? ")){
            answer = true;
        } else {
            answer = false;
        }
        System.out.println();
        return answer;
    }
}