package Base;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class IsValid {


    /**
     * isIp method
     *
     * Check if the parameter is valid IP
     * Using isReachable method
     *
     * @param ip String value of IP address
     * @return result boolean
     */
    public static boolean isIp(String ip) throws IOException {

        int timeOut = 3000;

        boolean status = InetAddress.getByName(ip).isReachable(timeOut);

        return status;
    }

    /**
     * isInt method
     *
     * Check if the parameter is valid Integer value
     *
     * @param s String value of an Integer
     * @return result boolean
     */
    public static boolean isInteger(String s) {

        boolean isValidInteger = false;
        try
        {
            Integer.parseInt(s);
            isValidInteger = true;

        } catch (NumberFormatException ex) {
            // s is not an integer
        }

        return isValidInteger;
    }

    /**
     * isYesNo method
     *
     * Get only Yes or No user answer
     * Also verifies if the answer is legitimate or not
     *
     * @param question
     * @return Yes or No answer
     */
    public static boolean isYesNo(String question){
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
}
