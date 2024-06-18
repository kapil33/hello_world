package gfg;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheUsingDoublyLL {
    class DLinkedList{
        int key, value;
        DLinkedList prev;
        DLinkedList next;
    }
    private void remove(DLinkedList node){
        DLinkedList prev = node.prev;
        DLinkedList next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private void moveToHead(DLinkedList node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private DLinkedList popTail(){
        DLinkedList node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }

    Map<Integer, DLinkedList> map;
    int CACHE_SIZE;
    DLinkedList head, tail;
    public LRUCacheUsingDoublyLL(int capacity){
        map = new HashMap<>();
        CACHE_SIZE = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();

        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if (map.containsKey(key)){
            DLinkedList node = map.get(key);
            remove(node);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            DLinkedList node = map.get(key);
            node.value = value;
            remove(node);
            moveToHead(node);
        }
        else{
            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.value = value;
            if (map.size() == CACHE_SIZE){
                DLinkedList node = popTail();
                map.remove(node.key);
            }
            map.put(newNode.key, newNode);
            moveToHead(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCacheUsingDoublyLL lru = new LRUCacheUsingDoublyLL(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}
