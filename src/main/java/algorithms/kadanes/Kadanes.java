package algorithms.kadanes;

import java.util.Arrays;

public class Kadanes {

    private int implementation1(int[] nums){
        int max = Integer.MIN_VALUE, currMax = 0;

        for(int i=0; i<nums.length; i++){
            currMax += nums[i];

            if(max < currMax)
                max = currMax;
            if (currMax < 0)
                currMax = 0;
        }

        return max;
    }

    private int implementation2(int[] nums){
        int max = nums[0], currMax = nums[0];

        for(int i=1; i<nums.length; i++){
            currMax = Math.max(nums[i], currMax + nums[i]);
            max = Math.max(max, currMax);
        }

        return max;
    }

    private int[] implementation3(int[] nums){
        int max = Integer.MIN_VALUE, currMax = 0;
        int p1 = 0, p2 = 0;
        int s = 0;

        for(int i=0; i<nums.length; i++){
            currMax += nums[i];

            if(max < currMax) {
                max = currMax;
                p1 = s;
                p2 = i;
            }
            if (currMax < 0) {
                currMax = 0;
                s = i+1;
            }
        }

        return new int[]{p1, p2};
    }

    public static void main(String[] args){
        Kadanes kd = new Kadanes();
        int[] nums1 = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int[] nums2 = new int[]{-3, -1, -2, -3, -5};

        int ans = kd.implementation1(nums2);
        System.out.println("Result using implementation1 is: " + ans);


        System.out.println("Result using implementation2 is: " + kd.implementation2(nums1));

        System.out.println("Largest sum contiguous array indices are: " + Arrays.toString(kd.implementation3(nums1)));
    }
}
