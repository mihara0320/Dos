package Base;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by masaki on 11/1/2016.
 */
public class Option{

    // Dictionary of options.
    static HashMap <Integer, String> options = new HashMap<>();

    // Load options to Dictionary.
    public static void loadContents(){
        options.put(0, "0: Setup default target");
        options.put(1, "1: ICMP Flood");
        options.put(2, "2: SYN Flood");
    }

    // Show all the options available.
    public static void showOptions() {

        Greeting.option();
        System.out.println();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
        System.out.println();
    }

    // Get user choice from option list.
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

    // Ask user YesNo question.
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

    // Ask user finish this program or not
    public static boolean exit(){

        boolean answer;

        System.out.println();

        if (askYesNo("Select another option? ")){
            answer = true;
        } else {
            answer = false;
        }
        System.out.println();
        return answer;
    }
}