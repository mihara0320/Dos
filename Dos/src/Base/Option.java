package Base;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by masaki on 11/1/2016.
 */
public class Option extends TargetData{
    // Dictionary of options
    static HashMap <Integer, String> options = new HashMap<>();
    public static boolean defaultTargetSetup;

    // Filling dictionary
    public static void loadContents(){
        options.put(0, "0: ICMP Flood");
        options.put(1, "1: SYN Flood");
    }

    public static void targetSetup(){

        boolean loop = true;

        do {
            System.out.println("You can either set up default target data now or configure each option later");
            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.print("Set up default target now? *Recommended* [yes/no]: ");
            String answer = input.nextLine();

            if (answer.equals("yes") || answer.equals("YES") || answer.equals("y") ){
                defaultTargetSetup = true;
                break;
            } else if (answer.equals("no") || answer.equals("NO") || answer.equals("n")){
                defaultTargetSetup = false;
                break;
            }
        } while (loop);
    }

    // Show all the options available
    public static void showOptions() {
        System.out.println("<<< Options >>>");
        System.out.println();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
        System.out.println();
    }

    // Let user select an attackLin method
    public static String getOption() {

        boolean loop = true;

        int userChoice = 10;

        do {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Select an attack method(enter a number): ");
                userChoice = Integer.parseInt(in.nextLine());
            } catch (Exception e){
                System.out.println("Error: Only integer value is accepted! ");
            }

            if (userChoice == 0 || userChoice == 1){
                break;
            } else {
                System.out.println("Enter either 0 or 1 !");
            }
        } while (loop);

        System.out.println();
        System.out.println("You have selected " + options.get(userChoice));
        System.out.println();


        String attackMethod = options.get(userChoice);

        return attackMethod;
    }

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

    public static boolean exit(){
        boolean answer;
        if (askYesNo("Another attack?")){
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}