import datastructure.Queue;
import datastructure.Stack;
import utils.DelimiterChecker;
import utils.StringReverser;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(1);
        Stack<String> stack = new Stack<>(2);


        String s1 = "a{[[bc](de)(fg)]}";                // -> true
        String s2 =  " a{{}}(bcdefg) ";            // -> true
        String s3 = "{[{]}";                        // -> false
        String s4 = "[][]{}{}}";                 // -> false
        String s5 = "][";                       //-> false
        String s6 = "({a}{a}[a]{b})" ;         // -> true
        String s7 = "[(){}][";                //  -> false
        String s8 = "(])";                   // -> false
        String s9 = "(]";                     // -> false
        String s10 = "{]";                  // -> false


        String[] s = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};

        try {
            int i = 1;
            for (String word : s) {
                System.out.println("s" + i + ": " + word + " -> " + DelimiterChecker.check(word));
                i++;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }





    }
}
