package algorithms.recursion.medium;

import java.util.HashMap;
import java.util.Map;

public class PowerOfX {

    /*Time complexity: O(logn)*/
    /*works for float x and negative y*/
    static Map<Integer, Float> memo2 = new HashMap<>();
    public static float pow3(float x, int n){
        if (n == 0)
            return 1;

        if(!memo2.containsKey(n)) {
            if (n % 2 == 0) {
                memo2.put(n, pow3(x, n / 2) * pow3(x, n / 2));
            } else {
                if (n > 0)
                    memo2.put(n, x * pow3(x, n / 2) * pow3(x, n / 2));
                else
                    memo2.put(n, pow3(x, n/2) * pow3(x, n/2) / x);
            }
        }

        return memo2.get(n);
    }

    /*Time complexity: O(logn)*/
    static Map<Integer, Integer> memo = new HashMap<>();
    public static int pow2(int x, int n){
        if (n == 1)
            return x;

        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, pow2(x, n / 2) * pow2(x, n / 2));
            } else {
                memo.put(n, x * pow2(x, n / 2) * pow2(x, n / 2));
            }
        }

        return memo.get(n);
    }

    /*Time complexity: O(n)*/
    public static int pow(int x, int n){
        if (n == 1)
            return x;

        return x * pow(x, n-1);
    }

    public static void main(String[] args){
        //System.out.println(pow2(2, 10));
        System.out.println(pow3(2, -3));
    }
}
