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

    @SuppressWarnings("unchecked")
    public void push(T newItem) {
        if (elements == null) {
            this.type = newItem.getClass();
            this.elements  = (T[]) new Object[arraySize];
        }
        top++;
        if (top == arraySize - 1 ) {
            resizeArray();
        }

        elements[top] = newItem;


    }

    public T peek() {
        if (elements == null || top < 0) {
            return null;
        }

        return elements[top];
    }

    public T pop() {
        if (elements == null || top == -1) {
            return null;
        }
        T value = elements[top];
        elements[top] = null;
        top--;
        return value;
    }

    @SuppressWarnings("unchecked")
    private void resizeArray() {
        T[] newArray = (T[]) new Object[arraySize + 1];

        for (int i = 0; i < arraySize; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
        arraySize++;

    }

    public void display() {
        for (int i = top; i >= 0 ; i--) {

            System.out.println("| " + elements[i] + " |");

        }
    }

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
