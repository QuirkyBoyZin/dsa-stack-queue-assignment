import datastructure.Queue;
import datastructure.Stack;
import utils.StringReverser;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(1);
        Stack<String> stack = new Stack<>(2);

        String s1 = "abcdefg";        // -> gfedcba
        String s2 =  " abcdefg ";    // trim trailing and leading spaces -> gfedcba
        String s3 = "123456";       // -> 654321
        String s4 = "654321";      // -> 123456
        String s5 = " ";          //-> throw IllegalArgumentException
        String s6 = "" ;         //  -> throw IllegalArgumentException
        String s7 = "c";        //  -> throw IllegalArgumentException

        String[] s = {s1,s2,s3,s4,s5,s6,s7};

        try {
            for (String word : s) {
                System.out.println(StringReverser.reverse(word));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }





    }
}
