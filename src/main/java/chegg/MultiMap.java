package chegg;

import java.util.*;

public class MultiMap {

    public static <K, V> void addToMultiMap(Map<K, Set<V>> map, K key, V value){
        Set<V> set = new HashSet<>();
        if (map.get(key) != null)
            set = map.get(key);
        set.add(value);

        map.put(key, set);
    }

    public static void main(String[] args){
        Map<Integer, Set<String>> map = new HashMap<>();
        addToMultiMap(map, 1, "kapil");
        addToMultiMap(map, 2, "raman");
        addToMultiMap(map, 3, "gaveesh");
        addToMultiMap(map, 1, "kapil");

        System.out.println(map);

        Map<Integer, Set<Integer>> mapTwo = new HashMap<>();
        addToMultiMap(mapTwo, 1, 11);
        addToMultiMap(mapTwo, 2, 22);
        addToMultiMap(mapTwo, 3, 33);
        addToMultiMap(mapTwo, 1, 11);

        System.out.println(mapTwo);
    }
}
