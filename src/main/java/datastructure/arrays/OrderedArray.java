package datastructure.arrays;

public class OrderedArray extends CustomArray
{

    /**
     * <p>Given a size, this constructor will create an Array of type {@code Integer } with {@code Null}
     * values according to the given size. </p>
     * <p> The {@code Null} values will be replaced when inserting elements. </p>
     * <p> The {@code Null} values indicates unused positions. </p>
     *
     * @param size the total capacity of the array.
     */
    public OrderedArray(int size) {
        super(size);
    }


    /**
     * Removing the first occurrence of the given element {@code e}.
     * <p>
     * After deletion, remaining elements will shift to the left such that all non-null
     * elements remain contiguous.
     *
     * @param e The element to be removed in the array.
     * @return {@code true}: the element is found deleted <br>
     *         {@code false}: the element is not found.
     *
     * @implNote Utilizes {@code Binary Search} searching algorithm to search for the element to be removed.
     * <p>
     * <b>Time Complexity Analysis:</b>
     * <ul>
     *   <li><b>Best Case O(1):</b> When {@code e} is at the middle index</li>
     *   <li><b>Worst Case O(n):</b> is at the last index or is not found and the shifting of all the elements</li>
     * </ul>
     */
    @Override
    public boolean delete(int e) {

        int index = find(e);
        boolean isFound = index != -1; // False when find(e) returns -1 (exist), false if it returns something else

        if (isFound) {
            // Shift all elements after the found index to the left by 1
            for (int i = index; i < pointer - 1; i++) {
                arr[i] = arr[i + 1];
            }

            // Null out the last element since it was shifted left
            arr[pointer - 1] = null;

            pointer--;
            count--; // Decrease element count tracking

            return true;
        }

        return false;
    }

    /**
     * <p>Inserting an integer to the array. </p>
     * <p> The array will automatically resize if it is full after insertion</p>
     *
     * @param e The element to be inserted into the array.
     * @implNote {@code O(n)} Time Complexity in all cases.
     */
    @Override
    public void insert(int e) {
        boolean isArrayFull = pointer == size;

        if (isArrayFull) {
            resize(size + 1);
        }

        // Find the correct position for 'e' to keep the array ordered
        // by shifting larger elements one position to the right
        int currentIndex = pointer - 1;
        while (currentIndex >= 0 && arr[currentIndex] != null && arr[currentIndex] > e) {
            arr[currentIndex + 1] = arr[currentIndex];
            currentIndex--;
        }

        // Insert the new element at the correct ordered position
        arr[currentIndex + 1] = e;

        pointer++;
        count++;

    }

    /**
     * Searches through the array to find the given element {@code e}.
     *
     * @param e the element to be found or not found
     * @return {@code Index} of the corresponding inputted element <br>
     *         {@code -1} if the inputted element doesn't exist
     *
     * @implNote Utilizes a {@code Binary Search} searching algorithm.
     * <p>
     * <b>Time Complexity Analysis:</b>
     * <ul>
     *   <li><b>Best Case O(1):</b> When {@code e} is at the middle index</li>
     *   <li><b>Worst Case O(logn):</b> When {@code e} element is not found or at any other particular index</li>
     * </ul>
     */
    @Override
    public int find(int e) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = ( low + high)  / 2;

            if (e == arr[mid]) {
                return mid;

            } else if (e > arr[mid]) {
                low = mid + 1;

            } else if (e < arr[mid]) {
                high = mid - 1;
            }

        }
            return -1;

    }
}
