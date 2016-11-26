package Base;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by kenzi on 11/26/16.
 */
public class OptionTest {

    HashMap<Integer, String> options = Option.options;
    public static HashMap<Integer, String> optionsTest = new HashMap<>();

    @Test
    public void loadContents() throws Exception {

        Option.loadContents();

        String option0 = options.get(0);
        String option1 = options.get(1);
        String option2 = options.get(2);
        String option3 = options.get(3);

        assertEquals("0: Setup default target", option0);
        assertEquals("1: ICMP Flood", option1);
        assertEquals("2: SYN Flood", option2);
        assertEquals(null, option3);
    }

    @Test
    public void showOptions() throws Exception {

    }

    @Test
    public void getOption() throws Exception {

    }

    @Test
    public void askYesNo() throws Exception {

    }

    @Test
    public void exit() throws Exception {

    }

}