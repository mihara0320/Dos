package Base;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by kenzi on 11/26/16.
 */
public class OptionTest {

    public static HashMap<Integer, String> optionsTest = new HashMap<>();

    @Test
    public void loadContents() throws Exception {

        Option.loadContents();

        String option0 = Option.getOptions(0);
        String option1 = Option.getOptions(1);
        String option2 = Option.getOptions(2);
        String option3 = Option.getOptions(3);

        assertEquals("0: Setup default target", option0);
        assertEquals("1: ICMP Flood", option1);
        assertEquals("2: SYN Flood", option2);
        assertEquals(null, option3);
    }

    @Test
    public void showOptions() throws Exception {

        loadContents();

        for (int i = 0; i < optionsTest.size() ; i++) {
            assertEquals(optionsTest.get(i), Option.getOptions(i));
        }
    }

}