package javaoutputquestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringApplication3 {
    public static void main(String[] args){
        //int[] arr = {3, 1, 5, 2, 4};
        String[] array = {"abc", "2", "10", "0"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(list.toArray()));

        /*
        * below statement returns:
        *   1. a negative integer if string1("apple") < string2("banana") lexicographically
        *   2. a positive integer if String1("cat") > string2("banana") lexicographically
        *   3. zero if both are same
        * */
        System.out.print("cat".compareTo("Cat"));
    }
}
