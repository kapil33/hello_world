package gfg.interviews.turtlemint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsInLL {
    /*
     * L1 -> 1, 1, 2, 3, 3, 4
     * L2 -> 3, 4, 4, 5
     * x = 6
     *
     * L1 -> 1, 1, 2, 3, 3, 4
     * L2 -> 3, 3, 4, 4, 5
     *
     * count = 2
     * */

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int count = 0, X=8;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<l1.size(); i++)
            map.put(l1.get(i), map.getOrDefault(l1.get(i), 0) + 1);

        //1st : count = 0 as 5 is not in l1
        //2nd : count = 1 as 4 exists once in l1
        //3rd : count = 3 as 3 exists twice in l1
        //result = 3

        for (int i=0; i<l2.size(); i++){
            if (map.get(X - l2.get(i)) != null && map.get(X - l2.get(i)) > 0){
                count++;
                map.put(X - l2.get(i), map.get(X - l2.get(i)) - 1);
            }
        }

    }
}
