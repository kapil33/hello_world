package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        // write your code her
        PriorityQueue<String> pq = new PriorityQueue<>(10, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        pq.add("G");
        pq.add("E");
        pq.add("E");
        pq.add("K");
        pq.add("S");
        pq.add("4");

        System.out.println(pq);

        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        System.out.println(res.get(res.size() - 1));

        HashMap<Integer, Integer> map = new HashMap<>();
        map.clear();
    }
}

