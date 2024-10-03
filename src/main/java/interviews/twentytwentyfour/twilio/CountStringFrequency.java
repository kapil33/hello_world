package interviews.twentytwentyfour.twilio;

import java.util.*;

public class CountStringFrequency {
    /**
     * Problem Statement: Consider a string that consists of lowercase english letters(from a to z) only. The following rules are used to encode all of its
     * characters into the string s.
     * i. a is encoded as 1, b as 2, c as 3....i as 9
     * ii. j is encoded as 10#, k as 11# and z as 26#
     * iii. if any character occurs two or more times consecutively,
     * its count immediately follows the encoded character in parentheses e.g. 'aa' is encoded as '1(2)'
     *
     * Examples:
     *  String "abzx" is encoded as "1226#24#"
     *  String "aabccc" is encoded as "1(2)23(3)"
     *  String "bajj" is encoded as "2110#(2)"
     *  String "wwxyzwww" is encoded as "23#(2)24#25#26#23#(3)"
     *
     *  Given an encoded string s, determine the character counts for each letter of the original, decoded string. Return array of 26 integers where
     *  0 contains the no. of 'a' characters, index 1 contains of 'b' and so on.
     *
     *  Input 1: "1226#24#"
     *  Output 1: [1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1]
     *
     *  Input 2: "1(2)23(3)"
     *  Output 2: [2,1,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
     *
     *  Input 3: "2110#(2)"
     *  Output 3: [1,1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
     *
     *  Input 4: "23#(2)24#25#26#23#(3)"
     *  Output 4: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,1,1,1]
     *
     */

    /*Garg's Algo*/
    public List<Integer> frequency(String s) {
        int[] freq = new int[26];
        int lastFreq = 0;

        for(int i=s.length()-1; i>=0;) {
            char c = s.charAt(i);

            if(c == '#') {
                int value = (s.codePointAt(i-2) - '0')*10 + s.codePointAt(i-1) - 1 - '0';
                if(lastFreq != 0) {
                    freq[value] += lastFreq;
                    lastFreq = 0;
                } else
                    freq[value] += 1;

                i = i-3;
            } else if(c == ')') {
                int start = i;

                while(s.charAt(i) != '(') {
                    i--;
                }
                int f = Integer.parseInt(s.substring(i+1, start));
                lastFreq = f;
                i--;
            } else {
                int value = s.codePointAt(i) - 1 - '0';

                if(lastFreq != 0) {
                    freq[value] += lastFreq;
                    lastFreq = 0;
                } else {
                    freq[value] += 1;
                }
                i--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<26; i++) {
            res.add(freq[i]);
        }

        return res;
    }

    public List<Integer> frequencyWithKaps(String s) {
        Stack<Character> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[26];
        int lastFreq = 0;

        for (int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));
        }

        while (!stack.isEmpty()) {
            char ch = stack.pop();

            if (ch == '#') {
                int unitsPlace = Integer.parseInt(String.valueOf(stack.pop()));
                int tensPlace = Integer.parseInt(String.valueOf(stack.pop()));
                int val = tensPlace*10 + unitsPlace;
                char c = (char) (96 + val);

                if (lastFreq != 0) {
                    freq[c - 'a'] += lastFreq;
                    lastFreq = 0;
                } else {
                    freq[c - 'a'] += 1;
                }
            } else if (ch == ')') {
                int val = 0, pow = 0;

                while(stack.peek() != '(') {
                    int num = Integer.parseInt(String.valueOf(stack.pop()));
                    val = (int) (num * Math.pow(10, pow++) + val);
                }
                lastFreq = val;
                stack.pop();
            } else {
                int val = Integer.parseInt(String.valueOf(ch));
                char c = (char) (96 + val);

                if (lastFreq != 0) {
                    freq[c - 'a'] += lastFreq;
                    lastFreq = 0;
                } else {
                    freq[c - 'a'] += 1;
                }
            }
        }

        for (int i=0; i<26; i++) {
            res.add(freq[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        String s1 = "1226#24#", s2 = "1(2)23(3)", s3 = "2110#(2)", s4 = "23#(2)24#25#26#23#(3)";
        CountStringFrequency csf = new CountStringFrequency();
        System.out.println(csf.frequency(s1));
        System.out.println(csf.frequency(s2));
        System.out.println(csf.frequency(s3));
        System.out.println(csf.frequency(s4));

        System.out.println("\n***************\n");

        System.out.println(csf.frequencyWithKaps(s1));
        System.out.println(csf.frequencyWithKaps(s2));
        System.out.println(csf.frequencyWithKaps(s3));
        System.out.println(csf.frequencyWithKaps(s4));
    }
}