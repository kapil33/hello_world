package interviews.twentytwentyfour.navi;

public class MinimumDaysToBloom {
    /*
        Problem Statement: Leetcode 1482
        https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

        Problem Statement in the interview:
        You are given 'N' roses and you are also given an array 'arr'  where 'arr[i]'  denotes that the 'ith' rose will
        bloom on the 'arr[i]th' day.
        You can only pick already bloomed roses that are adjacent to make a bouquet.
        You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
        Find the minimum number of days required to make at least 'm' bouquets each containing 'k' roses.
        Return -1 if it is not possible.

        Example 1:
        Input Format: N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2, k = 3
        Result: 12
        Explanation: On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

        Example 2:
        Input Format: N = 5, arr[] = {1, 10, 3, 10, 2}, m = 3, k = 2
        Result: -1

        Example 3:
        Input Format: N = 4, arr[] = {7, 5, 4, 3}, m = 1, k = 3
        Result: 5
*/


    public boolean isFeasible(int[] bloomDay, int m, int k, int minDays) {
        int countBouquets=0, countFlowers=0;

        for (int i=0; i<bloomDay.length; i++) {
            if (bloomDay[i] <= minDays) {
                countFlowers++;

                if (countFlowers == k) {
                    countBouquets++;
                    countFlowers=0;
                }
            } else {
                countFlowers=0;
            }
        }

        return countBouquets >= m;
    }

    public int getMinDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length == 0 || bloomDay.length < m*k)
            return -1;

        int start=bloomDay[0], end=bloomDay[0];

        for(int i=1; i<bloomDay.length; i++) {
            if(start > bloomDay[i])
                start = bloomDay[i];
            if(end < bloomDay[i])
                end = bloomDay[i];
        }
        if(bloomDay.length == m*k)
            return end;

        while(start < end) {
            int mid = start + (end-start)/2;

            if(isFeasible(bloomDay, m, k, mid))
                end = mid;
            else
                start = mid+1;
        }

        if (isFeasible(bloomDay, m, k, start))
            return start;
        else
            return -1;
    }

    public static void main(String[] args) {
        MinimumDaysToBloom minimumDaysToBloom = new MinimumDaysToBloom();
        System.out.println(minimumDaysToBloom.getMinDays(new int[]{7, 7, 7, 7, 13, 11, 12, 7}, 2, 3));
        System.out.println(minimumDaysToBloom.getMinDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(minimumDaysToBloom.getMinDays(new int[]{7, 5, 4, 3}, 1, 3));
    }
}