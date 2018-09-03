package krd180000;

/**
 * Implemention of the bounded-sized queue Data structure using arrays.
 * @param <T> type of elements in the queue
 */
public class BoundedQueue<T> {
    private Object[] data;
    private int size;
    private int indx;
    public BoundedQueue(int size){
        this.size=0;
        data = new Object[size];
    }
    boolean offer(T x){
        size++;
        return true;
    }

    T poll(){
        size--;
        return null;
    }

    T peek(){
        return (T)data[indx];
    }

    int size(){
        return data.length;
    }

    boolean isEmpty(){
        return size==0;
    }

    void clear(){
        size=0;
    }

    void toArray(T[] a){

    }
}
