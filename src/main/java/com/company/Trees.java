package com.company;

import java.util.*;

public class Trees {


    public static void main(String[] args) {
        // write your code her
        Set<Integer> s = new TreeSet<>();

        TreeSet<Integer> ts = new TreeSet<Integer>();
        List<Integer> l = Arrays.asList(10, 12, 14, 3, 6, 8, 20, 17, 9);
        for (Integer num: l){
            ts.add(num);
        }

        System.out.println("first: " + ts.first());
        System.out.println("last: " + ts.last());
        System.out.println("lowest: " + ts.lower(8));
        System.out.print("highest: " + ts.higher(14));
        System.out.println("floor: " + ts.floor(5));

        Iterator<Integer> it = ts.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Iterator<Integer> dit = ts.descendingIterator();
        while (dit.hasNext()) {
            System.out.println(dit.next());
        }

        SortedSet<Integer> ss = new TreeSet<>();
    }
}
