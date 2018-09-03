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
        tester.testOffer();
        tester.testPoll();
        tester.testPeek();
        tester.testSize();
        tester.testIsEmpty();
        tester.testClear();
        tester.testToArray();
        System.out.println("all tests passed");
    }

    private void testOffer() {
        //offer on empty queue

        //offer on normal queue

        //offer on one less than full

        //offer on full
    }

    private void testPoll() {
        //poll on empty queue

        //poll on one more than empty

        //poll on normal queue

        //poll on one less than full

        //poll on full

    }

    private void testPeek() {
        //peek on empty

        //peek on one more than empty

        //peek on normal queue

        //peek on one less than full

        //peek on full
    }

    private void testSize() {

    }

    private void testIsEmpty() {
        //when full

        //when empty
    }

    private void testClear() {
        //clear on empty

        //clear on normal

        //clear on full
    }

    private void testToArray() {
        //on empty

        //on normal

        //on full
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
