package gfg.interviews.morganstanley;

import java.util.HashMap;
import java.util.Map;

public class CircularString {

    /*
    * Problem Statement: you are given a string, each character in the string is an uppercase alphabet (A to Z)
    * starting from first index of the string jump to the next string(in either direction) and so on and so forth.
    * Remember that next character for Z is A as its circular.
    * Return the minimum no. of jumps.
    *
    * For Example:
    * String = "AZGB"
    *
    * Explanation:
    * A to Z = 1 jump
    * Z to G = 7 jumps
    * G to B = 5 jumps
    * Minimum Jumps = 1 + 7 + 5 = 13 jumps
    *
    * */

    public static int printCircularString(String s){
        Map<Character, Integer> map = new HashMap<>();
        int alpha = 65;
        for (int i=1; i<=26; i++){
            map.put((char)alpha, i);
            alpha++;
        }

        int res = 0;
        char last = 'A';

        for (int i=0; i<s.length(); i++){
            int diff1 = Math.abs(map.get(s.charAt(i)) - map.get(last));
            int diff2 = 26-diff1;
            if (diff1 < diff2)
                res += diff1;
            else
                res += diff2;

            last = s.charAt(i);
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println("Minimum jumps are: " + printCircularString("AZGB"));
        System.out.println("Minimum jumps are: " + printCircularString("A"));
    }
}
