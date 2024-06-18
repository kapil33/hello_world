package algorithms.kadanes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeOnes {

    /*
    *Problem Statement: Given a binary array and an integer m, find the position of zeroes flipping which creates maximum number of consecutive 1’s in array.
    *
    * Examples :
        Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
                 m = 2
        Output:  5 7
        We are allowed to flip maximum 2 zeroes. If we flip
        arr[5] and arr[7], we get 8 consecutive 1's which is
        maximum possible under given constraints
    *
    * */

    public static int[] maximumOnes(int[] nums, int k){
        int i=0, j=0, zeros=0, max = Integer.MIN_VALUE;
        int[] index = new int[2];

        while(j < nums.length){
            if(nums[j] == 0)
                zeros++;
            while (zeros > k){
                if (nums[i] == 0)
                    zeros--;
                i++;
            }

            if (max < j-i+1){
                index[0] = i;
                index[1] = j;
                max = j-i+1;
            }
            j++;
        }

        List<Integer> result = new ArrayList<>();
        for(int z=index[0]; z<=index[1]; z++){
            if(nums[z] == 0)
                result.add(z);
        }

        int[] output = new int[result.size()];
        for (int z=0; z<result.size(); z++)
            output[z] = result.get(z);

        return output;
    }

    public static void main(String[] args){
        System.out.println("Result is: " + Arrays.toString(maximumOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)));
        System.out.println("Result is: " + Arrays.toString(maximumOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3)));
    }
}