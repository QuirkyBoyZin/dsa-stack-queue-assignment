import datastructure.Queue;
import datastructure.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(1);
        Stack<String> stack = new Stack<>(2);

        stack.push("gay");
        stack.push("bruh");
        stack.push("lol");
        stack.push("bro");

        stack.pop();
        stack.push("bro");
        stack.push("bro");
        stack.push("gay");


        System.out.println(stack);


        System.out.println(stack.peek());

        stack.display();


    }
}
