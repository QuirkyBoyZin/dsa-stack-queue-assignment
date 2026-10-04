import datastructure.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>(5);

        String[] item = new String[]{"A", "B", "C", "D", "E", "T", "F", "W"};
        int[]    priorityValue = new int[]{3,4,3,2,1,10,9,11};

        for (int i = 0; i < item.length; i++) {
            queue.insert(item[i], priorityValue[i]);
        }

        // E, D, C, A, B, F
        for (int i = 0; i < item.length + 100; i++) {
            queue.peekRear();
            queue.peekFront();
            queue.remove();
            queue.peekFront();
            for (int j = 0; j < item.length; j++) {
                queue.insert(item[j], priorityValue[j]);
            }
        }
        queue.display();
        System.out.println(queue);












    }
}
