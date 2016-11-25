package Base;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by kenzi on 19/11/2016.
 */
public class IsValid {


    // Check if the input value is a valid ip address.
    public static boolean isIp(String ip) throws IOException {

        int timeOut = 3000;

        boolean status = InetAddress.getByName(ip).isReachable(timeOut);

        return status;
    }

    // Check if the input value is an integer.
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
