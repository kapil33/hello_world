package algorithms.recursion.medium;

import java.util.*;

public class SubsequencesOfString {
    static List<String> result = new ArrayList<>();

    public static void findSubsequence(String input, String output){
        if (input.isEmpty()){
            if (!output.isEmpty())
                result.add(output);
            return;
        }

        findSubsequence(input.substring(1), input.charAt(0) + output);
        findSubsequence(input.substring(1), output);
    }

    public static void main(String[] args){
        String str = "abc";
        findSubsequence(str, "");

        //Collections.sort(result);
        System.out.println(result);
        System.out.println("Size of array: " + result.size());
    }
}
