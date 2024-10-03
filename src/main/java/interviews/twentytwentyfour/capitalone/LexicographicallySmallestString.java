package interviews.twentytwentyfour.capitalone;

import java.util.*;

public class LexicographicallySmallestString {

    /*
    * Problem Statement:
    * https://www.geeksforgeeks.org/lexicographically-smallest-string-which-is-not-a-substring-of-given-string/
    * */

    public String getLexicographicallySmallestString(String str) {
        Set<String> subStringSet = new HashSet<>();

        for (int i=0; i<str.length(); i++) {
            String curr = "";
            for (int j=i; j<str.length(); j++) {
                curr += str.charAt(j);

                subStringSet.add(curr);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (int i=0; i<26; i++) {
            q.add(String.valueOf((char) ('a' + i)));
        }

        while (!q.isEmpty()) {
            String curr = q.remove();
            if (!subStringSet.contains(curr))
                return curr;

            for (int i=0; i<26; i++) {
                curr += String.valueOf((char) ('a' + i));
                q.add(curr);
                curr = curr.substring(0, curr.length()-1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        LexicographicallySmallestString lss = new LexicographicallySmallestString();

        System.out.println(lss.getLexicographicallySmallestString("aabacdefghijklmnopqrstuvwxyz"));
        System.out.println(lss.getLexicographicallySmallestString("abc"));
    }
}