package Base;


import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kenzi on 11/14/16.
 */
public class Attack {

    private static String defaultTargetIp;
    private static String adhocTargetIp;

    public static ArrayList<Integer> defaultOpenPorts = new ArrayList<>();
    public static ArrayList<Integer> adhocOpenPorts = new ArrayList<>();

    public static boolean defaultTargetSetup;

    public static void setDefaultTargetIp(String targetIp) throws IOException {
        defaultTargetIp = targetIp;
    }

    public static void setAdhocTargetIp(String targetIp) throws IOException {
        adhocTargetIp = targetIp;
    }

    public static String getDefaultTargetIp(){
        String result = defaultTargetIp;
        return result;
    }

    public static String getAdhocTargetIp(){
        String result = adhocTargetIp;
        return result;
    }

}

