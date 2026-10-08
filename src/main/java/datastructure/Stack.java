package datastructure;
import java.util.Arrays;

public class Stack <T>{
    private int top = -1;
    private T[] elements;
    private Class<?> type;
    private int arraySize;

    public Stack(int arraySize) {
        if (arraySize <= 0) {
            throw new IllegalArgumentException("arraySize must not be less than or equal to 0! ");
        }

        this.arraySize = arraySize;
    }

    // O(n): Worst case if the stack is full needs to resize
    // O(1): Best case if the stack is not full
    @SuppressWarnings("unchecked")
    public void push(T newItem) {
        if (elements == null) {
            this.type = newItem.getClass();
            this.elements  = (T[]) new Object[arraySize];
        }
        top++;

        if (top == arraySize - 1 ) {
            System.out.println(this);
            resizeArray();
        }

        elements[top] = newItem;

    }

    // O(1): Accessing array is instant because we have a top which can directly get us to the top of the stack
    public T peek() {
        if (elements == null || top < 0) {
            return null;
        }

        return elements[top];
    }

    // O(1): Accessing array is instant because we have a top which can directly get us to the top of the stack
    // and setting an element to null is also constant
    public T pop() {
        if (elements == null || top == -1) {
            return null;
        }
        T value = elements[top];
        elements[top] = null;
        top--;
        return value;
    }

    // O(n): Copying elements from the old array into the new array
    @SuppressWarnings("unchecked")
    private void resizeArray() {
        T[] newArray = (T[]) new Object[arraySize * 2];

        for (int i = 0; i < arraySize; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
        arraySize *= 2;

    }

    // O(n): Iterating over the entire stack then displaying
    public void display() {
        for (int i = top; i >= 0 ; i--) {

            System.out.println("| " + elements[i] + " |");

        }
    }

    // O(n): While top, type arraySize is constant time but Arrays.toString() needs to iterate
    // over the array to convert every element into a String
    @Override
    public String toString() {
        return "datastructure.Stack{" +
                "top=" + top +
                ", elements=" + Arrays.toString(elements) +
                ", type=" + type +
                ", arraySize=" + arraySize +
                '}';
    }
}
