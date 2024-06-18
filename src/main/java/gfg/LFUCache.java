/*
package gfg;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LFUCache {
    PriorityQueue<Pair<Integer, Integer>> pq;
    private final int CACHE_SIZE;

    public LFUCache(int capacity) {
        this.pq = new PriorityQueue<>(capacity, Comparator.comparing(Pair::getValue));
        CACHE_SIZE = capacity;
    }

    public void refer(int page){
        if (pq.contains(page)){
            //just increase the frequency of that page
            int frequency = pq.remove();
        }
        else{
            //case 1: if cache is full, then remove LFU page and add this page
            if (pq.size() == CACHE_SIZE){
                System.out.println("removing: " + pq.peek());
                pq.poll();
                pq.add(new Pair<>(page, 1));
            }
            //case 2: if cache not full, then just add this page
            else{
                pq.add(new Pair<>(page, 1));
            }
        }
    }

    public void display(){
        for (Pair<Integer, Integer> pair : pq) {
            System.out.println(pair);
        }
    }

    public static void main(String[] args) {

    }
}
*/
