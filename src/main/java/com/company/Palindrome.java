package com.company;

public class Palindrome {
    public static void main(String[] args){
        System.out.println("answer is: " + pal("mm"));
    }

    public static boolean pal(String str){
        // safety check
        if(str == null)
            return false;
        // base case
        if (str.length() <= 1)
            return true;

        return (str.charAt(0) == str.charAt(str.length() - 1))
                && pal(str.substring(1, str.length() - 1));
    }
}

/*Solution 1: w/o pointers
*
public static boolean pal(String str){
        // safety check
        if(str == null)
            return false;
        // base case
        if (str.length() <= 1)
            return true;

        return (str.charAt(0) == str.charAt(str.length() - 1))
                && pal(str.substring(1, str.length() - 1));
    }
    *

* Solution 2: with pointers
* public static boolean pal(String str, int start, int end){
        // safety check
        if(str == null)
            return false;
        // base case
        if (start >= end)
            return true;

        return pal(str, start+1, end-1);
    }
 */
