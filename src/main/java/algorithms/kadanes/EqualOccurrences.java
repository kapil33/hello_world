package algorithms.kadanes;

import java.util.HashMap;
import java.util.Map;

public class EqualOccurrences {
    /*Problem Statement: there is an integer array consisting of only positive integers.
    Output the count of sub-arrays that have equal no. of odd and even integers.
    For Example:
    arr = {4,5,6,7} , answer =  4
    arr = {4,5,7,6} , answer =  3
    * */

    /*brute force: time complexity: O(n^2)*/
    public static int countSubArray(int[] nums){
        int count = 0;

        for (int i=0; i<nums.length; i++){
            int odds=0, evens=0;
            for (int j=i; j<nums.length; j++){
                if (nums[j] % 2 == 0)
                    evens++;
                else
                    odds++;
                if (odds == evens)
                    count++;
            }
        }

        return count;
    }

    /*time complexity: O(n)*/
    public static int countSubArray2(int[] nums){
        int count = 0, sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i=0; i<nums.length; i++){
            if (nums[i]%2 == 0)
                sum += 1;
            else
                sum += -1;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        for (Integer mapKey: map.keySet()){
            count += map.get(mapKey)*(map.get(mapKey)-1)/2;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubArray2(new int[]{4,5,7,8}));
        System.out.println(countSubArray2(new int[]{4,5,6,7}));
        System.out.println(countSubArray2(new int[]{1, 0, 0, 1, 0, 1, 1}));
    }
}
