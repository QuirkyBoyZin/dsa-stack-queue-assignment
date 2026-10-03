import datastructure.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(1);

        queue.peekFront();
        queue.peekRear();
//        for (int i = 1; i < 11; i++) {
//            queue.insert(i);
//        }
//        queue.display();
    }
}
