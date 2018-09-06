package krd180000;

/**
 * Implemention of the bounded-sized queue Data structure using arrays.
 * @param <T> type of elements in the queue
 */
public class BoundedQueue<T> {
    private Object[] data;
    private int size; //no of elements currently in the queue
    private int capacity; //max size current queue can store
    private int head; //index of earliest inserted entry
    private int tail; //index of the next free place

    /**
     *  Initializes a BoundedQueue of given size
     * @param size Queue capacity
     * @throws IllegalArgumentException when given size is zero or negative
     */
    public BoundedQueue(int size){
        if(size<=0){
            throw new IllegalArgumentException("incorrect size value given for queue");
        }
        clear();
        this.capacity = size;
        data = new Object[size];
    }

    /**
     * add a new element x at the rear of the queue
     * returns false if the element was not added because the queue is full
     * @param x element to be added
     * @return boolean representing if element is added to queue or not
     */
    public boolean offer(T x){
        if(size>=capacity)
            return false;
        size++;
        data[tail] = x;
        tail = (tail+1)%capacity;
        return true;
    }

    /**
     * remove and return the element at the front of the queue
     * return null if the queue is empty
     * @return the element removed from queue or null if empty
     */
    public T poll(){
        if(size==0)
            return null;
        T returnVal = cast(data[head]);
        head = (head+1)%capacity;
        size--;
        return returnVal;
    }

    /**
     * return front element, without removing it (null if queue is empty)
     * @return front element or null (if empty)
     */
    public T peek(){
        if(size==0)
            return null;
        return cast(data[head]);
    }

    /**
     * return the number of elements in the queue
     * @return number of elements currently in the queue
     */
    public int size(){
        return size;
    }

    /**
     * check if the queue is empty
     * @return true is empty else false
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * clears the queue
     */
    public void clear(){
        size=0;
        head=0;
        tail=0;
    }

    /**
     * fill user supplied array with the elements of the queue, in queue order
     * @param a array to be filled
     * @throws IllegalArgumentException if passed array is smaller than queue size
     */
    public void toArray(T[] a){
        if(a.length<size){
            throw new IllegalArgumentException("size of passed array is too small");
        }
        int cursor = head;
        for(int i=0;i<size;++i){
            a[i] = cast(data[cursor]);
            cursor=(cursor+1)%capacity;
        }
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
