package krd180000;

/**
 * Implemention of the bounded-sized queue Data structure using arrays.
 * @param <T> type of elements in the queue
 */
public class BoundedQueue<T> {
    private Object[] data;
    private int size;
    private int head;
    private int tail;
    public BoundedQueue(int size){
        this.size=0;
        this.head=-1;
        this.tail=-1;
        data = new Object[size];
    }

    /**
     * add a new element x at the rear of the queue
     * returns false if the element was not added because the queue is full
     * @param x
     * @return
     */
    public boolean offer(T x){
        size++;
        tail = (tail+1)/size;
        return true;
    }

    /**
     * remove and return the element at the front of the queue
     * return null if the queue is empty
     * @return
     */
    public T poll(){
        T returnVal = cast(data[head]);
        size--;
        return returnVal;
    }

    /**
     * return the number of elements in the queue
     * @return
     */
    public T peek(){
        return cast(data[head]);
    }

    /**
     * return the number of elements in the queue
     * @return
     */
    public int size(){
        return data.length;
    }

    /**
     * check if the queue is empty
     * @return true is empty else false
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * clear the queue
     */
    public void clear(){
        size=0;
    }

    /**
     * fill user supplied array with the elements of the queue, in queue order
     * @param a array to be filled
     */
    public void toArray(T[] a){

    }

    /**
     * Type casts given element to T. Reason for doing it in a function is that suppress warning can be done
     * at only one place.
     * @param element element to be type casted.
     * @return element type-casted to T.
     */
    @SuppressWarnings("unchecked")
    private T cast(Object element){
        return (T) element;
    }
}
