package Base;


import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class Attack {

    private static String defaultTargetIp;
    private static String adhocTargetIp;

    public static ArrayList<Integer> defaultOpenPorts = new ArrayList<>();
    public static ArrayList<Integer> adhocOpenPorts = new ArrayList<>();

    public static boolean defaultTargetSetup;

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

