package leetcode;

import javafx.util.Pair;

import java.util.*;

class xClass{}

public class StringFunc {
    public static void main(String[] args){
        String s1 = "kapilchoudhary";
        //s1 = "ch";
        s1 = s1.concat(" is a boss");
        System.out.println(s1);
        String s2 = "chou";
        System.out.println("a to empty string: " + "ba".compareTo("b"));

        if(s2.charAt(0) != 'c') return;

        if(s2.equals(s1.substring(5, 9)))
            System.out.println("true");

        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        for(Integer val : map.values()){

        }
        //map.put(new Pair<>(0, 1), 0);

        List<Integer> l = new ArrayList<>();
        //int[] nums = new int[]{1,2,2,3};
        //l.add(Arrays.asList(new Integer(nums)));
        l.toArray(new xClass[l.size()]);

        StringBuilder sb = new StringBuilder("asctvgvv");
        int[] nums = new int[]{1,2,3};
        Set<Integer> s = new HashSet<>();
        Iterator it = s.iterator();
        it.next();

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        Pair<Integer, Integer> pair = q.poll();
        Map<Character, Integer> m = new HashMap<>();
        m.put('A', 1);
        return;



        /**
         *
         * Set<Integer> s1 = new HashSet<>();
         *         Set<Integer> s2 = new HashSet<>();
         *         Set<Integer> result = new HashSet<>();
         *
         *         for(int i=0; i<nums1.length; i++)
         *             s1.add(nums1[i]);
         *         for(int i=0; i<nums2.length; i++)
         *             s2.add(nums2[i]);
         *
         *         while(s1.isEmpty()){
         *
         *         }
         */

    }
}