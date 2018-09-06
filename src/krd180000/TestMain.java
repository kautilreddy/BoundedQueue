package krd180000;

/**
 * This is a driver class that essentially runs tests (like a JUnit test class).
 * Motivation to write such a class is:
 * 1.To eliminate adding JUnit or TestNG dependency.
 * 2.To act as a spec-sheet for the implemented functions.
 *
 * To add a new test case,
 * 1.Create a test function.
 * 2.Call the test function from main.
 * @author Kautil & Anirudh
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
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        //offer on empty queue
        assert queue.offer(1);
        //offer on normal queue
        assert queue.offer(2);
        //offer on one less than full
        assert queue.offer(3);
        //offer on full
        assert !queue.offer(4);
        //offer when tail is at 0
        assert queue.poll()==1;
        assert queue.offer(4);
    }

    private void testPoll() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        //poll on empty queue
        assert queue.poll()==null;
        //poll on one more than empty
        queue.offer(1);
        assert queue.poll()==1;
        //poll on normal queue
        queue.offer(1);
        queue.offer(2);
        //poll on one less than full
        assert queue.poll()==1;
        queue.offer(3);
        queue.offer(4);
        //poll on full
        assert queue.poll() == 2;
        assert queue.poll() == 3;
        assert queue.poll() == 4;
        //poll when head and tail are same but not at 0
        assert queue.poll() == null;
    }

    private void testPeek() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        //peek on empty
        assert queue.peek()==null;
        //peek on one more than empty
        queue.offer(1);
        assert queue.peek()==1;
        assert queue.size()==1;

        //peek on one less than full
        queue.offer(2);
        assert queue.peek() == 1;

        //peek on full
        queue.offer(3);
        assert queue.peek() == 1;
        assert queue.size()==3;
        queue.poll();
        assert queue.peek() == 2;
    }

    private void testSize() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        assert queue.size()==0;
        queue.offer(1);
        assert queue.size()==1;
        queue.offer(2);
        assert queue.size()==2;
        queue.offer(3);
        assert queue.size()==3;
        queue.poll();
        queue.offer(4);
        assert queue.size()==3;
    }

    private void testIsEmpty() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        //when empty
        assert queue.isEmpty();
        //when full
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assert !queue.isEmpty();
        //when empty but head and tail are not at initial position
        queue.poll();
        queue.poll();
        queue.poll();
        assert queue.isEmpty();
    }

    private void testClear() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        //clear on empty
        queue.clear();
        assert queue.isEmpty();
        //clear on normal
        queue.offer(1);
        queue.offer(2);
        queue.clear();
        assert queue.isEmpty();
    }

    private void testToArray() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        Integer arr[] = new Integer[3];
        //on empty
        queue.toArray(arr);
        assert arr[0]==null;
        assert arr[1]==null;
        assert arr[2]==null;
        //on normal
        queue.offer(1);
        queue.offer(2);
        queue.toArray(arr);
        assert arr[0]==1;
        assert arr[1]==2;
        assert arr[2]==null;

        //on full
        queue.offer(3);
        queue.poll();
        queue.offer(4);
        queue.toArray(arr);
        assert arr[0]==2;
        assert arr[1]==3;
        assert arr[2]==4;

        //check exception when small array is passed
        try {
            queue.toArray(new Integer[1]);
            assert false;
        }catch (Exception e){
            assert e instanceof IllegalArgumentException;
        }
    }
}
