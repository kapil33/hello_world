package interviews.wayfair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagrams {
    /*
    * Problem Statement: Given a list of words and a list of queries, for each query find the
    * corresponding anagram in the words. Two strings are anagrams if the occurrence of characters in both are same.
    * For ex: abcd and dbca are anagrams.
    * */

    public List<List<String>> getAnagrams(List<String> words, List<String> queries) {
        List<List<String>> result = new ArrayList<>();
        int[][] count = new int[words.size()][26];

        for (int i=0; i<words.size(); i++) {
            String s = words.get(i);
            for (int j=0; j<s.length(); j++) {
                count[i][s.charAt(j) - 'a']++;
            }
        }

        for (int i=0; i<queries.size(); i++) {
            String s = queries.get(i);
            int[] subCount = new int[26];
            List<String> subResult = new ArrayList<>();

            for (int j=0; j<s.length(); j++) {
                subCount[s.charAt(j) - 'a']++;
            }

            for (int k=0; k<count.length; k++) {
                if (Arrays.equals(count[k], subCount))
                    subResult.add(words.get(k));
            }
            Collections.sort(subResult);
            result.add(subResult);
        }

        return result;
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.getAnagrams(
                Arrays.asList("duel", "lude", "cat", "act", "same"),
                Arrays.asList("tac", "lued", "abc")));
    }
}