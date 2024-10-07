package interviews.twentytwentyfour.abstractsecurities;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SpecialLRUCache {
    /*
    * Problem statement: Build an in-memory cache that supports key -> value and value -> key lookups in O(1) time.
    * The cache should implement LRU (approximate is ok) cache eviction. Consider the following performance trade-offs:
    *
    * The cache is used in a system with high read concurrency.
    * Inserts to the cache are very infrequent.
    * Consider different options for data structures to optimize for these goals.
    *
    *
    */
    class BiDirectionalCache<K, V> {

        private final int MAX_ELEMENTS = 50_000;
        private Deque<K> dq = new LinkedList<>();
        private Map<K, V> keyToValMap = new HashMap<>();
        private Map<V, K> valToKeyMap = new HashMap<>();


        public K getByValue(V value) {
            if (valToKeyMap.containsKey(value)) {
                K key = valToKeyMap.get(value);
                dq.remove(key);
                dq.addFirst(key);

                return key;
            } else
                return null;
        }

        public V getByKey(K key) {
            if (keyToValMap.containsKey(key)) {
                dq.remove(key);
                dq.addFirst(key);

                return keyToValMap.get(key);
            } else
                return null;
        }

        public void insert(K key, V value) {
            if(keyToValMap.containsKey(key)) {
                dq.remove(key);
            } else {
                if(dq.size() == MAX_ELEMENTS) {
                    K removedKey = dq.removeLast();
                    V val = keyToValMap.get(removedKey);

                    keyToValMap.remove(removedKey);
                    valToKeyMap.remove(val);
                }
            }

            dq.addFirst(key);
            keyToValMap.put(key, value);
            valToKeyMap.put(value, key);
        }
    }

}
