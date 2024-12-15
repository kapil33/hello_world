package gfg;

public class KadanesMultiply {

    private int mult(int[] nums){
        int max = nums[0], currMax = nums[0], currMin = nums[0];

        for(int i=1; i<nums.length; i++){
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], currMax*nums[i]);
            currMin = Math.min(nums[i], currMin*nums[i]);
            max = Math.max(max, currMax);
        }

        return max;
    }

    public static void main(String[] args){
        KadanesMultiply kdm = new KadanesMultiply();

        int[] nums1 = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int[] nums2 = new int[]{-3, -1, -2, -3, -5};

        System.out.println("Largest multiply contiguous array is: " + kdm.mult(nums1));
        System.out.println("Largest multiply contiguous array is: " + kdm.mult(nums2));
    }
}
