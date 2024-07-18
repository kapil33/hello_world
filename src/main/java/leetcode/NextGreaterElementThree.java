package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextGreaterElementThree {

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int getNextGreaterNumber(int m) {
        List<Integer> list = new ArrayList<>();
        int n = m;
        while(n != 0){
            list.add(n%10);
            n /= 10;
        }
        int[] nums = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            nums[list.size()-i-1] = list.get(i);
        int i=nums.length-1;
        for(; i>0; i--){
            if(nums[i] > nums[i-1])
                break;
        }
        if(i == 0)
            return -1;
        int smallest = i;
        for(int j=i+1; j<nums.length; j++){
            if(nums[i-1] < nums[j] && nums[j] <= nums[smallest])
                smallest = j;
        }
        swap(nums, i-1, smallest);
        Arrays.sort(nums, i, nums.length);

        long ans = 0; // this cannot be int because int by default <= Integer.MAX_VALUE
        for(i=0; i<nums.length; i++)
            ans = ans*10+nums[i];
        return ans <= Integer.MAX_VALUE ? (int)ans:-1;
    }

    public static void main(String[] args) {
        System.out.println(getNextGreaterNumber(23));
        System.out.println(getNextGreaterNumber(12));
        System.out.println(getNextGreaterNumber(21));
        System.out.println(getNextGreaterNumber(123673));
        System.out.println(getNextGreaterNumber(230241));
        System.out.println(getNextGreaterNumber(2147483486)); //output is greater than Integer.MAX_VALUE
    }
}
