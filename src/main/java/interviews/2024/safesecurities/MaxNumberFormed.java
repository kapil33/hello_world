package interviews.SafeSecurities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNumberFormed {
    /*You are given an array of positive integers > 0. The task at hand is to rearrange the array elements so that
    * , finally, when the numbers are joined, they make a single positive integer/number.
    * It should be the maximum number that can be formed using the array elements.
    *
    * Input 1:
    *   array = [1,2,3]
    * Output 1:
    *   321
    *
    * Input 2:
    *   array = [1,23,4]
    * Output 2:
    *   4231
    *
    * Input 3:
    *   array = [5,56,508]
    * Output 3:
    *   565508
    * */

    public boolean isGreater(int i, int j) {
        List<Integer> num1 = new ArrayList<>(), num2 = new ArrayList<>();

        while (i != 0) {
            num1.add(i%10);
            i /= 10;
        }
        while (j != 0) {
            num2.add(j%10);
            j /= 10;
        }

        i = num1.size()-1;
        j=num2.size()-1;

        while (i >= 0 && j >= 0) {
            if (num1.get(i) < num2.get(j))
                return true;
            else if (num1.get(i) > num2.get(j))
                return false;
            else {
                i--;
                j--;
            }
        }

        if (i >= 0) {
            return num1.get(i) == 0;
        }
        if (j >= 0) {
            return num2.get(j) != 0;
        }

        return false;
    }

    public int calcPowerOfTen(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }

        return count;
    }

    public int getMaximumNumber(int[] nums) {
        int result=0, n=0;

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (isGreater(nums[i], nums[j])) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i=nums.length-1; i>=0; i--) {
            result += nums[i] * Math.pow(10, n);
            n = calcPowerOfTen(result);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxNumberFormed maxNumberFormed = new MaxNumberFormed();

        System.out.println(maxNumberFormed.getMaximumNumber(new int[]{1,2,3}));

        System.out.println(maxNumberFormed.getMaximumNumber(new int[]{1,23,4}));

        System.out.println(maxNumberFormed.getMaximumNumber(new int[]{56,5,508}));

        System.out.println(maxNumberFormed.getMaximumNumber(new int[]{56,51,508}));

        System.out.println(maxNumberFormed.getMaximumNumber(new int[]{96,9,806}));
    }
}