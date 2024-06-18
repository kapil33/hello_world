package algorithms.recursion.easy;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibo(int nums) {
        if (nums == 1 || nums == 0)
            return nums;

        if (!memo.containsKey(nums)) {
            memo.put(nums, fibo(nums - 1) + fibo(nums - 2));
        }

        return memo.get(nums);
    }

    public static void main(String[] args){
        System.out.println(fibo(10));
    }
}
