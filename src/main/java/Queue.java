import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue <T> {
    private Class<?> type;        // The type of the array during runtime
    private T[] elements;     // The elements in the queue
    private int arraySize;       // The length of the queue

    private int nextQueue;      // Points at the next element to enqueue
    private int currentQueue;  // Points at the current element to be dequeued

    public Queue(int arraySize) {
        this.arraySize = arraySize;
    }

    @SuppressWarnings("unchecked")  // Avoid this message: "Unchecked cast: 'java.lang.Object' to 'T[]'
    public void insert(T newItem) {
        if (elements == null) {
            this.type = newItem.getClass();
            elements = (T[])Array.newInstance(type,arraySize);
        }

        if (nextQueue == arraySize) {
            resizeArray();
        }

        elements[nextQueue] = newItem;
        nextQueue++;
    }

    public T remove() {
        if (elements == null) {
            return null;
        }

        T removedElement = elements[currentQueue];
        elements[currentQueue] = null;
        currentQueue++;

        return removedElement;

    }

    public T peekFront() {
        if (elements == null) {
            return null;
        }

        return elements[currentQueue];
    }

    public T peekRear() {
        if (elements == null) {
            return null;
        }
        return elements[nextQueue - 1];
    }


    @Override
    public String toString() {
        return "Queue{" +
                "type=" + type +
                ", elements=" + Arrays.toString(elements) +
                ", arraySize=" + arraySize +
                ", nextQueue=" + nextQueue +
                ", currentQueue=" + currentQueue +
                '}';
    }

    public void display() {
        System.out.print(" Out ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(" <- | " + elements[i] + " | ");

        }
        System.out.print(" <--- Queue Here ");


    }

    @SuppressWarnings("unchecked")
    private void resizeArray() {
        T[] newArray = (T[])Array.newInstance(type,arraySize + 1);

        for (int i = 0; i < arraySize; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
        arraySize++;

    }



}
