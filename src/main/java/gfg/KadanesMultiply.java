package gfg;

public class KadanesMultiply {

    private int mult(int[] nums){
        int max = Integer.MIN_VALUE, max_so_far = 1;

        for(int i=0; i<nums.length; i++){
            max_so_far *= nums[i];

            if (max < max_so_far)
                max = max_so_far;
            if (max_so_far <= 0)
                max_so_far = 1;
        }

        return max;
    }

    public static void main(String[] args){
        KadanesMultiply kdm = new KadanesMultiply();

        int[] nums1 = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int[] nums2 = new int[]{-3, -1, -2, -3, -5};

        int ans = kdm.mult(nums1);
        System.out.println("Largest multiply contiguous array is: " + ans);
    }
}
