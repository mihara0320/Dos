package Base;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kenzi on 11/26/16.
 */
public class IsValidTest {

    @Test
    public void isIp() throws Exception {

        boolean loopback = IsValid.isIp("127.0.0.1");

        assertEquals(true, loopback);

    }

    @Test
    public void isInteger() throws Exception {

        int[] testInt;
        testInt = new int[]{0, 1, 2, 55, 10000};

        for (int i = 0; i < 5; i++) {
            String testValue = String.valueOf(testInt[i]);
            boolean test = IsValid.isInteger(testValue);

            assertEquals(true, test);
        }

        String[] testString;
        testString = new String[]{"a", "test", "@", "()", "テスト"};

        for (int i = 0; i < 5; i++) {
            String testValue = testString[i];
            boolean test = IsValid.isInteger(testValue);

            assertEquals(false, test);
        }

    }

}