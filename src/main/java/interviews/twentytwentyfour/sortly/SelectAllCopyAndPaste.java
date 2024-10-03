package interviews.twentytwentyfour.sortly;

import java.util.HashMap;
import java.util.Map;

public class SelectAllCopyAndPaste {

    /*
    * Problem statement: You have a custom keyboard which has below keys:
    *
    * Key 1: records single A on the screen
    * Key 2: select all the contents on the screen
    * Key 3: copy all the selected content on the screen to the buffer
    * Key 4: paste the contents of the buffer
    *
    * Given N operations, return the maximum A's that can be achieved.
    *
    * Input 1: 3
    * Output 1: 3
    * Explanation: press 3 A's
    *
    * Input 2: 6
    * Output 2: 6
    * Explanation: press 6 A's or press 3 A's & then select all, copy and paste
    *
    * Input 3: 7
    * Output 3: 9
    * Explanation: press 3 A's then [select all, copy and paste] then paste
    *
     * */

    /*
     * Memoization approach:
     * TC: O(n*n)
     * SC: O(n+n) = O(n)
     * */
    Map<Integer, Integer> memo = new HashMap<>();
    public int calcWithMemo(int n) {
        if (!memo.containsKey(n)) {
            if(n <= 6) {
                memo.putIfAbsent(n, n);
            } else {
                int max = n, mult = 2;

                for (int i=n-3; i>=1; i--) {
                    max = Math.max(max, (mult++) * calc(i));
                }

                memo.put(n, max);
            }
        }

        return memo.get(n);
    }

    /*
    * Brute Force Approach:
    * TC: O(n^n)
    * SC: O(n)
    * */
    public int calc(int n) {
        if(n <= 6)
            return n;

        int max = n;
        int mult = 2;

        for (int i=n-3; i>=1; i--) {
            max = Math.max(max, (mult++) * calc(i));
        }

        return max;
    }

    public static void main(String[] args) {
        SelectAllCopyAndPaste sortly = new SelectAllCopyAndPaste();

        System.out.println(sortly.calc(6));
        System.out.println(sortly.calc(8));
        System.out.println(sortly.calc(9));
        System.out.println(sortly.calc(10));
        System.out.println(sortly.calc(15));

        System.out.println(sortly.calcWithMemo(15));
    }
}