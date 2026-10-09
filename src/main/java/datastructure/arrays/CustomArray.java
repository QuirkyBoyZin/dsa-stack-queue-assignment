package datastructure.arrays;

import java.util.Arrays;

/**
 * <p> This class serves as a blueprint to build the {@link OrderedArray} and {@link UnorderedArray} class </p>
 * <p> Implementations of this class, will have different use cases, disadvantages and advantages.</p>
 * <p> Key characteristics for the implementation will be written in the Javadoc's  {@code @implNote }  field.</p>
 */
abstract public class CustomArray<T> {

    protected T[] arr;      // Element will be set to null to indicate unused positions.
    protected int size;           // The Total number of elements in the array (both non-null and null elements)
    protected int count   = 0;          // Number of non-null elements
    protected int pointer = 0;    // point at the nearest null entry in the array from left to right

    /**
     * @return The Total number of elements in the array (both non-null and null elements).
     */
    public int size() {
        return size;
    }

    /**
     * @return The number of non-null elements in the array.
     */
    public int count() {
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }


    /**
     * <p>Given a size, this constructor will create an Array of type {@code Integer } with {@code Null}
     * values according to the given size. </p>
     * <p> The {@code Null} values will be replaced when inserting elements. </p>
     * <p> The {@code Null} values indicates unused positions. </p>
     * @throws IllegalArgumentException if given size less than 1.
     * @param size the total capacity of the array.
     */
    @SuppressWarnings("unchecked")
    public CustomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0!");
        }
        this.size = size;
        this.arr = (T[]) new Object[size];
    }

    /**
     * <p> Get the element according to the given index </p>
     * @param index the position of a particular element
     * @return {@code Null}  if no element exist at the given index <br>
     * {@code Element } at that index
     * @throws IndexOutOfBoundsException If the given index is not greater or equal to 0
     */
    public T get(int index) {
        return arr[index];
    }

    /**
     * <p>Removing the first occurrence of the given element. </p>
     * <p>After deletion, remaining elements will shift to the left such that all non-null elements remain contiguous.</p>
     *
     * @param e The element to be removed into the array.
     * @return {@code True}: the element is found deleted
     * {@code False}: the element is not found.
     */
    public abstract boolean delete(T e);

    /**
     * <p> Searches through the array to find the inputted element {@code e}. </p>
     *
     * @param e the element to be searched for
     * @return <p> Index of {@code e} if exists <br> {@code -1 } if {@code e} doesn't exist</p>
     */
    public abstract int find(T e);

    /**
     * <p>Inserting an integer to the array. </p>
     * <p> The array will automatically resize if it is full after insertion</p>
     * @param e The element to be inserted into the array.
     */
    public abstract void insert(T e);

    /**
     * <p> Changes the size of the array to the given {@code newSize }, While preserving the existing elements' order</p>
     * @throws IllegalArgumentException if given newSize less than 1.
     */
    protected void resize(int newSize){
        if (newSize < 1) {
            throw new IllegalArgumentException("New size must be greater than 0!");
        }

        // recount the number of non-null element after resizing if newSize is less than current size
        if (newSize < size) {
            countNonNullElement();
        }

        pointer = newSize - 1;
        arr  = Arrays.copyOfRange(arr, 0, newSize);
        size = newSize;

    }

    private void countNonNullElement() {
        for (T i : arr) {
            if (i != null) {
                count++;
            }
        }

    }

}
