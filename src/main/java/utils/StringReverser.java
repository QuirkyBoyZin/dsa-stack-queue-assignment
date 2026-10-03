package utils;
import datastructure.Stack;

public class StringReverser {
    public static String reverse(String input){
        if (input.isBlank() || input.length() == 1) {
            throw new IllegalArgumentException("Please enter atleast 2 letters");
        }
        //remove any trailing or leading spaces
        input = input.trim();
        int stringLength = input.length();


        Stack<String> stack = new Stack<>(stringLength);

        // Build the reversed String later by popping the stack
        String reversedInput = "";

        // get the sequence of letters from input
        char[] charArr = input.toCharArray();

        for (char c : charArr) {
            // Convert to a string then push to stack
            stack.push(String.valueOf(c));
        }


        for (int i = 0; i < stringLength ; i++) {
            // Pop the top of the stack then concatenating with the last string
            reversedInput += stack.pop();
        }

        return reversedInput;

    }
}
