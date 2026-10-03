package utils;

import datastructure.Stack;

public class DelimiterChecker {
    public static boolean check(String input) {
        if (input.isBlank() || input.length() == 1) {
            throw new IllegalArgumentException("Please enter a complete string");
        }
        //remove any trailing or leading spaces
        input = input.trim();
        int stringLength = input.length();

        Stack<String> stack = new Stack<>(stringLength);

        // get the sequence of letters from input to iterate over
        char[] charArr = input.toCharArray();

        // Check for [ { ( and ] { )
        for (char delimiter : charArr) {
            // Only Push to stack if there is an opening delimiter in the string
            if (isOpeningDelimiter(delimiter)) {
                stack.push(String.valueOf(delimiter));

            } else if (isClosingDelimiter(delimiter)) {
                char closingDelimiter   = delimiter;
                String openingDelimiter = stack.pop();  // The top should be an opening delimiter to match with the closing

                // null means there was never an opening delimiter to close with in the beginning
                if (openingDelimiter == null) {
                    return false;
                }

                // Only returning false if the opening and closing delimiter doesn't match !
                if (!isMatchingDelimiter(openingDelimiter.charAt(0), closingDelimiter)  ) {
                    return false;
                }
            }
        }

        // if the top of the stack isn't equal to null, it means there is still one or multiple opening delimiters still left in the stack
        if (stack.peek() != null) {
            return false;
        }

        // returning true if and only the stack is empty
        return true;
    }


    public static boolean isOpeningDelimiter(char openingDelimiter) {
        return openingDelimiter == '[' || openingDelimiter ==  '{' || openingDelimiter == '(';
    }
    public static boolean isClosingDelimiter(char closingDelimiter) {
        return closingDelimiter == ']' || closingDelimiter ==  '}' || closingDelimiter == ')';
    }
    public static boolean isMatchingDelimiter(char openingDelimiter, char closingDelimiter) {
        return (openingDelimiter == '[' && closingDelimiter == ']') || (openingDelimiter == '{' && closingDelimiter == '}') || (openingDelimiter == '(' && closingDelimiter == ')');
    }
}
