package datastructure;
import java.util.Arrays;

record Item<T>(T item, int priorityValue) {

    @Override
    public String toString() {
        return (String) item;
    }

}

public class PriorityQueue  <T > {
    private Class<?> type;        // The type of the array during runtime
    private Item<T>[] items;     // The elements in the queue
    private int arraySize;       // The length of the queue

    private int rear;      //   Points at the last element
    private int front;    //    Points at the first  element to be dequeued

    public PriorityQueue(int arraySize) {
        if (arraySize <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }

        this.arraySize = arraySize;
    }

   @SuppressWarnings("unchecked")
    public void insert(T newItem, int priorityValue) {
        if (items == null) {
            this.type = newItem.getClass();
            items =  new Item[arraySize];
        }

       insertToArray(newItem, priorityValue);

   }


    @SuppressWarnings("unchecked")
    private void resizeArray() {
        Item<T>[] newArray =  new Item[arraySize * 2];

        for (int i = 0; i < arraySize; i++) {
            newArray[i] = items[i];
        }


        items = newArray;
        arraySize *=2;

    }

    public T remove() {
        if (items == null) {
            return null;
        }

        Item<T> removedElement = items[front];
        items[front] = null;
        if (removedElement == null) {
            return null;
        }

        front++;

        return removedElement.item();

    }

    public T peekFront() {
        if (items == null || items[rear - 1] == null) {
            return null;
        }

        return items[front].item();
    }

    public T peekRear() {
        if (items == null || items[rear - 1] == null) {
            return null;
        }

        return items[rear - 1].item();
    }

    public void display() {
        System.out.print(" Out ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(" <- | " + items[i] + ": " + ((items[i] == null)? null:items[i].priorityValue() + " | "));

        }
        System.out.println(" ");


    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "type=" + type +
                ", elements=" + Arrays.toString(items) +
                ", arraySize=" + arraySize +
                ", rear=" + rear +
                ", front=" + front +
                '}';
    }

    private void insertToArray(T newItem, int priorityValue) {
        if (rear + 1 == arraySize) resizeArray();

        Item<T> item = new Item<>(newItem, priorityValue);

        int index = findInsertionPosition(item);

        // index == -1 means the item is the lowest priority
        if (index == -1 ) {
            items[rear] = item;
            rear++;
            return;
        }

        if (items[index] != null) shiftArray(index);

        items[index] = item;
    }


    private int findInsertionPosition(Item<T> item) {
        for (int i = 0; i < arraySize; i++) {
            if (items[i] != null && item.priorityValue() <= items[i].priorityValue() ) {
                return i; // insert at the left of the lower priorityValue
            }
        }
        return -1;
    }

    private void shiftArray(int index) {
        for (int i = rear + 1; i > index; i--) items[i] = items[i-1];
        rear++;
    }
}
