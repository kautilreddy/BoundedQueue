package krd180000;

import java.util.NoSuchElementException;

/**
 * @author Kautil
 * This is a driver class that essentially runs tests (like a JUnit test class).
 * Motivation to write such a class is:
 * 1.To eliminate adding JUnit or TestNG dependency.
 * 2.To act as a spec-sheet for the implemented functions.
 *
 * To add a new test case,
 * 1.Create a test function.
 * 2.Call the test function from main.
 */
public class TestMain {
    /**
     * the TestMain here runs the individual test functions.
     * @param args this argument is added just to maintain consistency with java spec.
     */
    public static void main(String[] args) {
        try {
            assert false;
            System.out.println("Please use the -ea jvm-option. Ex: java -ea krd180000.TestMain");
            System.exit(0);
        }catch (AssertionError error){
            System.out.println("-ea option enabled good to go");
        }
        TestMain tester = new TestMain();
        System.out.println("all tests passed");
    }

    /**
     * Runs the given function inside a try-catch block to capture and assert that NoSuchElementException is raised
     * @param function function that needs to be run inside the try block
     */
    private void checkNoSuchElementException(Runnable function){
        try {
            function.run();
            assert false;
        }catch (Exception e){
            assert e instanceof NoSuchElementException;
        }
    }
}
