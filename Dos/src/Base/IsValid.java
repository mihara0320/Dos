package Base;

import java.io.IOException;
import java.net.InetAddress;

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
}
