package interviews.twentytwentyfour.flipkart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastUniqueNumber {
    /*
    * Question 1:
    In earlier Flipkart BBDs, there used to be an online game where users kept on bidding (input) a
    * number throughout the sale and at the end of the BBD the user with a bid of smallest unique number was
    *  the winner of the game. Consider the bidding number inputs as a stream of integers, and find the
    * least unique number on each input.

    Example Input 1:

    4 3 1 1 2 2 3 5

    Example Output 1:
    Least unique number: 4
    Least unique number: 3
    Least unique number: 1
    Least unique number: 3
    Least unique number: 2
    Least unique number: 3
    Least unique number: 4
    Least unique number: 4

    Example Input 2:

    1 1 2 2 3 3

    Example Output 2:
    Least unique number: 1
    Least unique number: MAX_VALUE
    Least unique number: 2
    Least unique number: MAX_VALUE
    Least unique number: 3
    Least unique number: MAX_VALUE
    *
    *
    * My Explanation:

4 3 1 1 2 2 3 5

Set/Map: 4, 3, 1, 2, 5
MinHeap: 4, 5
Output(root of minHeap): 4, 3, 1, 3, 2, 3, 4, 4

TC for each ops: O(1) + O(logn)

TC for n elements: O(n * (logn)) ~ O(nlogn)
SC: O(n + n + n) ~ O(n)

***************

[1,1,2,2,3,3]

Set/Map: [{1,1}, {2,1}]
MinHeap: 2

o/p: [1, MAX, 2]
* */

    public int[] getLeastUniqueNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> uniqueMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            if(!uniqueMap.containsKey(nums[i])) {
                uniqueMap.put(nums[i], 1);
                pq.add(nums[i]);
            } else {
                pq.remove(nums[i]);
            }

            if(!pq.isEmpty())
                result[i] = pq.peek();
            else
                result[i] = Integer.MAX_VALUE;
        }

        return result;
    }

    public static void main(String[] args) {
        LeastUniqueNumber lun = new LeastUniqueNumber();
        int[] nums = new int[] {4, 3, 1, 1, 2, 2, 3, 5};
        System.out.println(Arrays.toString(lun.getLeastUniqueNumber(nums)));

        nums = new int[]{1, 1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(lun.getLeastUniqueNumber(nums)));
    }

}
