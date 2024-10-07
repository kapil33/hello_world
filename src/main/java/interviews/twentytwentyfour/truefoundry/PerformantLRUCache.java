package interviews.twentytwentyfour.truefoundry;

import java.util.HashMap;
import java.util.Map;

public class PerformantLRUCache {
    /*
    * Problem Statement: Design a data structure that follows the constraints of an LRU cache.
    * Implement the LRUCache class:
    * 1. LRUCache(int capacity): initialize the LRU cache with positive size capacity
    * 2. int get(int key): returns the value of the key if the key exists otherwise return -1
    * 3. void put(int key, int value): update the value of the key if the key exists. Otherwise, add the key-value pair
    * to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    *
    * Example:
    * LRUCache cache = new LRUCache(2);
    * cache.put(1, 1); // cache is {1=1}
    * cache.put(2, 2); // cache is {1=1, 2=2}
    * cache.get(1); // return 1
    * cache.put(3, 3); // LRU key was 2, evict key 2, cache is {3=3, 1=1}
    * cache.get(2); // return -1
    * cache.put(4, 4); // LRU key was 1, evict key 1, cache is {4=4, 3=3}
    * cache.get(1); // return -1
    * cache.get(3); // return 3
    * cache.get(4); // return 4
    * */

    static class DLL {
        int key;
        int val;
        DLL prev;
        DLL next;

        public DLL(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

        public DLL(int key, int val, DLL prev, DLL next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    final int CACHE_SIZE;
    DLL firstNode, lastNode;
    Map<Integer, DLL> keyToNodeMap;

    public PerformantLRUCache(int cacheSize) {
        CACHE_SIZE = cacheSize;
        firstNode = null;
        lastNode = null;
        keyToNodeMap = new HashMap<>();
    }

    public int get(int key) {
        if(!keyToNodeMap.containsKey(key))
            return -1;
        DLL node = keyToNodeMap.get(key);
        markMostRecentlyUsed(node);

        return node.val;
    }

    public void put(int key, int value) {
        if(!keyToNodeMap.containsKey(key)) {
            if(keyToNodeMap.size() == CACHE_SIZE) {
                // remove lastNode from DLL and map
                removeLastNode();
            }

            // create a new node and add in front of DLL
            DLL newNode = new DLL(key, value);
            newNode.next = firstNode;

            if(firstNode != null)
                firstNode.prev = newNode;
            else
                lastNode = newNode;

            firstNode = newNode;
            keyToNodeMap.put(key, newNode);
        }  else {
            DLL node = keyToNodeMap.get(key);
            markMostRecentlyUsed(node);
            node.val = value;
        }
    }

    private void removeLastNode() {
        int lastNodeKey = lastNode.key;
        DLL newLastNode = lastNode.prev;
        newLastNode.next = null;
        lastNode = newLastNode;
        keyToNodeMap.remove(lastNodeKey);
    }

    private void markMostRecentlyUsed(DLL node) {
        if(node != firstNode) {
            DLL prevNode = node.prev;
            DLL nextNode = node.next;
            prevNode.next = nextNode;
            if (nextNode != null)
                nextNode.prev = prevNode;
            else
                lastNode = prevNode;

            node.next = firstNode;
            node.prev = null;
            firstNode.prev = node;
            firstNode = node;
        }
    }

    public void displayDLL() {
        DLL trav = firstNode;

        while (trav != null) {
            System.out.print(trav.key + "=" + trav.val + ", ");
            trav = trav.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        PerformantLRUCache lruCache = new PerformantLRUCache(2);
        lruCache.put(1, 1);
        lruCache.displayDLL();
        lruCache.put(2, 2);
        lruCache.displayDLL();
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        lruCache.displayDLL();
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        lruCache.displayDLL();
        lruCache.put(3, 5);
        lruCache.displayDLL();
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
