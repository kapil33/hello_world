package interviews.twentytwentyfour.paypay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringManipulator {
    /*
    * Problem Statement: Task is to simulate a text editor which can handle 3 types of operations:
    * 1. INSERT <text> - adds <text> to the end of the current text
    * 2. BACKSPACE - erases the last character of the current text but if current text is empty then it does nothing
    * 3. UNDO - undo the last successful INSERT/BACKSPACE operation. If there is nothing to undo then it does nothing
    *
    * Input 1: ["INSERT Code", "INSERT Signal", "BACKSPACE", "UNDO"]
    * Output 1: ["Code", "CodeSignal", "CodeSigna", "CodeSignal"]
    *
    * Input 2: ["INSERT co", "INSERT d", "UNDO", "BACKSPACE", "UNDO", "INSERT ding"]
     * Output 2: ["co", "cod", "co", "c", "co", "coding"]
    * */

    public String[] applyOperations(String[] operations) {
        StringBuilder sb = new StringBuilder();
        String[] result = new String[operations.length];
        String previousStr = new String();

        for (int i=0; i<operations.length; i++) {
            String str = operations[i];
            String[] s = str.split(" ");

            if (s[0].equals("INSERT")) {
                previousStr = sb.toString();
                sb.append(s[1]);
                result[i] = sb.toString();
            } else if (s[0].equals("BACKSPACE")) {
                previousStr = sb.toString();

                if (sb.length() > 0)
                    sb = new StringBuilder(sb.substring(0, sb.length()-1));

                result[i] = sb.toString();
            } else {
                sb = new StringBuilder(previousStr);
                result[i] = sb.toString();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        StringManipulator sm = new StringManipulator();
        String[] str = new String[]{"INSERT Code", "INSERT Signal", "BACKSPACE", "UNDO"};
        String[] str2 = new String[]{"INSERT co", "INSERT d", "UNDO", "BACKSPACE", "UNDO", "INSERT ding"};

        System.out.println(Arrays.toString(sm.applyOperations(str)));
        System.out.println(Arrays.toString(sm.applyOperations(str2)));

        /*Our code does not work for below input*/
        String[] str3 = new String[]{"INSERT Code", "INSERT Signal", "BACKSPACE", "UNDO", "UNDO", "UNDO"};
        System.out.println(Arrays.toString(sm.applyOperations(str3)));
    }
}