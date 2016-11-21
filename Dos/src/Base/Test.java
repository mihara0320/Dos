package Base;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kenzi on 21/11/2016.
 */
public class Test {

    public static String printURI() {
        String uri = System.getProperty("user.dir");
        System.out.println(uri);

        return uri;
    }
}
