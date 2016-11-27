package Base;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Masaki Ihara
 * @version 1.0
 */
public class TestRunner {

    /**
     * runUnitTest method
     *
     * Perform Unit Testing for taken parameter Class
     *
     * @param test
     */
    public static void runUnitTest(Class test) {

        Result result = JUnitCore.runClasses(test);

        if (result.wasSuccessful()){
            System.out.println(" Unit Tests for " + test + " successful!");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }

    }
}
