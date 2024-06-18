package gfg;

import java.util.*;

public class LRUCache {
    private final int CACHE_SIZE;
    Deque<Integer> dq;
    Set<Integer> set;

    public LRUCache(int capacity) {
        CACHE_SIZE = capacity;
        dq = new LinkedList<>();
        set = new HashSet<>();
    }

    private void refer(int page) {
        if (set.contains(page)){
            dq.remove(page);
        }
        else{
            if (dq.size() == CACHE_SIZE) {
                set.remove(dq.removeLast());
            }
        }
        dq.addFirst(page);
        set.add(page);
    }

    private void display(){
        for (Integer integer : dq) {
            System.out.println(integer + " ");
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(1);
        lruCache.refer(4);
        lruCache.refer(5);
        lruCache.refer(2);
        lruCache.refer(2);
        lruCache.refer(1);
        lruCache.display();
    }
}
