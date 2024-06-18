package algorithms.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {
    static List<String> result = new ArrayList<>();

    public static void perms(String str, int index){
        if(index == str.length()-1) {
            result.add(str);
            return;
        }

        for (int i=index; i<str.length(); i++){
            StringBuilder sb = new StringBuilder(str);
            char temp = sb.charAt(index);
            sb.setCharAt(index, sb.charAt(i));
            sb.setCharAt(i, temp);

            perms(sb.toString(), index+1);
        }

        return;
    }

    public static void main(String[] args){
        String input = "ABC";
        perms(input, 0);
        System.out.println(result.toString() + "\n" + input);
        System.out.println("List length = " + result.size());
    }
}
