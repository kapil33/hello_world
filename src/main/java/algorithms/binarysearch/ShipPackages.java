package algorithms.binarysearch;

public class ShipPackages {

    /**
     * Problem Statement: Leet Code 1011:
     * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
     */

    public boolean isFeasible(int[] weights, int days, int minCapacity) {
        int countDays=0, countCapacity=0;

        for(int i=0; i<weights.length; i++) {
            countCapacity += weights[i];

            if(countCapacity > minCapacity) {
                countDays++;
                countCapacity = weights[i];
            }
        }

        if(countCapacity > 0) {
            countDays++;
        }

        return countDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int start=0, end=0;

        for(int i=0; i<weights.length; i++) {
            if(start < weights[i])
                start = weights[i];
            end += weights[i];
        }

        while(start < end) {
            int mid = start + (end-start)/2;

            if(isFeasible(weights, days, mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        ShipPackages shipPackages = new ShipPackages();

        System.out.println(shipPackages.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(shipPackages.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(shipPackages.shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
