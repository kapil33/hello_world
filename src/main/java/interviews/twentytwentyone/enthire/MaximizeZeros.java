package interviews.twentytwentyone.enthire;

public class MaximizeZeros {
    /*
    *Problem statement: Given a binary array, find the maximum number of zeros in an array with one flip of a sub-array allowed.
    * A flip operation switches all 0s to 1s and 1s to 0s.
    *
    * For Example:
    * Input :  arr[] = {0, 1, 0, 0, 1, 1, 0}
    * Output : 6
    * We can get 6 zeros by flipping the subarray {1, 1}
    *
    * */


    /*time complexity: O(n + n^3)*/
    public static int maximizeZeros(int[] nums){
       int max = Integer.MIN_VALUE;
       int zeros = 0, ones = 0;

       for (int i=0; i<nums.length; i++){
           if (nums[i] == 0)
               zeros++;
           else
               ones++;
       }

       for (int i=0; i<nums.length; i++){
           for (int j=i; j<nums.length; j++){
               int subZeros = 0, subOnes = 0;

               for (int k=i; k<=j; k++){
                   if (nums[k] == 0)
                       subZeros++;
                   else
                       subOnes++;
               }

               if (max < zeros+subOnes-subZeros)
                   max = zeros+subOnes-subZeros;
           }
       }

       return max;
    }

    /*time complexity: O(n + n^2)*/
    public static int maximizeZeros2(int[] nums){
        int max = Integer.MIN_VALUE;
        int zeros = 0, ones = 0;

        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0)
                zeros++;
            else
                ones++;
        }

        for (int i=0; i<nums.length; i++){
            int subZeros = 0, subOnes = 0;
            for (int j=i; j<nums.length; j++){
                if (nums[j] == 0)
                    subZeros++;
                else
                    subOnes++;

                if (max < zeros+subOnes-subZeros)
                    max = zeros+subOnes-subZeros;
            }
        }

        return max;
    }

    /*Another Approach
    *time complexity: O(n^2)
    * */
    public static int maximizeZeros3(int[] nums){
        int maxDiff = Integer.MIN_VALUE;
        int zeros = 0;

        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0)
                zeros++;

            int subZeros = 0, subOnes = 0;
            for (int j=i; j<nums.length; j++){
                if (nums[j] == 0)
                    subZeros++;
                else
                    subOnes++;

                if (maxDiff < subOnes-subZeros)
                    maxDiff = subOnes-subZeros;
            }
        }

        return zeros + maxDiff;
    }

    /*time complexity: O(n)*/
    public static int maximizeZeros4(int[] nums){
        int maxDiff = Integer.MIN_VALUE, currMax = 0;
        int zeros = 0;

        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0){
                zeros++;
                nums[i] = -1;
            }

            /*currMax += nums[i];
            if (maxDiff < currMax)
                maxDiff = currMax;
            if (currMax < 0)
                currMax = 0;*/
            currMax = Math.max(nums[i], currMax+nums[i]);
            maxDiff = Math.max(maxDiff, currMax);
        }
        /*in case if array do not have 1s*/
        maxDiff = Math.max(0, maxDiff);


        return zeros + maxDiff;
    }

    public static void main(String[] args){
        System.out.println("Maximum zeros are: " + maximizeZeros4(new int[]{0, 1, 0, 0, 1, 1, 0}));
        System.out.println("Maximum zeros are: " + maximizeZeros4(new int[]{1, 1, 1, 1, 1, 1, 1}));
        System.out.println("Maximum zeros are: " + maximizeZeros4(new int[]{0, 0, 0, 1, 0, 1}));
        System.out.println("Maximum zeros are: " + maximizeZeros4(new int[]{0, 0, 0, 0, 0, 0}));
    }
}
