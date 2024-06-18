package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueImplement {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(4);
        pq.add(6);
        pq.add(1);
        pq.add(3);

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
    }
}
