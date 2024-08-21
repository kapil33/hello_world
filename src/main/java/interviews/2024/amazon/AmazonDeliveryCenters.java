package interviews.amazon;

public class AmazonDeliveryCenters {
    /*
    * Problem Statement: Amazon has multiple delivery centers and delivery warehouses all over the world!
    * The world is represented by a number line from -10^9 to 10^9. There are n delivery centers, the ith one at
    * location center[i]. A location x is called a suitable location for a warehouse if it is possible to bring
    * all the products to that point by travelling a distance of no more than d. At any one time, products can be
    * brought from one delivery center and placed at point x. Given the positions of n delivery centers, calc the no. of
    * suitable locations in the world.
    * That is, calculate the no. of points x on the number line (-10^9 <= x <= 10^9) where the travel distance
    * required to bring all the products to that point is less than or equal to d.
    *
    * Note: the distance between point x and center[i] is |x - center[i]|, their absolute distance.
    *
    * Input 1: center=[-2, 1, 0] , d=8
    * Answer 1: 3
    *
    * Input 2: center=[2, 0, 3, -4] d=22
    * Answer 2: 5
    *
    * Input 3: center=[-3, 2, 2] d=8
    * Answer 3: 0
    *
    * */

    public boolean isFeasible(int[] center, int d, int i) {
        int totalDistance=0;

        for (int j=0; j<center.length; j++) {
            totalDistance += Math.abs(center[j]-i) * 2;
        }

        return totalDistance <= d;
    }

    /*My algorithm which gave wrong answer in Amazon Online Assessment*/
    public int getSuitableLocations(int[] center, int d) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, count=0;
        for (int i=0; i<center.length; i++) {
            if (min > center[i])
                min = center[i];
            if (max < center[i])
                max = center[i];
        }

        int mid = min + Math.abs(max-min)/2;
        int k = mid;
        while (isFeasible(center, d, k)) {
            count++;
            k--;
        }
        k = mid+1;
        while (isFeasible(center, d, k)) {
            count++;
            k++;
        }

        return count;
    }

    /*Nitin's Algorithm*/
    public int getSuitableLocationsTwo(int[] center, int d) {
        int leftMostIdeal = Integer.MIN_VALUE, rightMostIdeal = Integer.MAX_VALUE, count = 0;
        for (int i=0; i<center.length; i++) {
            leftMostIdeal = Math.max(leftMostIdeal, center[i] - d/2);
            rightMostIdeal = Math.min(rightMostIdeal, center[i] + d/2);
        }

        for (int i=leftMostIdeal; i<=rightMostIdeal; i++) {
            if (isFeasible(center, d, i))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        AmazonDeliveryCenters adc = new AmazonDeliveryCenters();

        int[] center = new int[] {-2,1,0};
        System.out.println(adc.getSuitableLocations(center, 8));

        center = new int[] {2,0,3,-4};
        System.out.println(adc.getSuitableLocations(center, 22));

        center = new int[] {-3,2,2};
        System.out.println(adc.getSuitableLocations(center, 8));

        System.out.println("\n****************************\n");

        center = new int[] {-2,1,0};
        System.out.println(adc.getSuitableLocationsTwo(center, 8));

        center = new int[] {2,0,3,-4};
        System.out.println(adc.getSuitableLocationsTwo(center, 22));

        center = new int[] {-3,2,2};
        System.out.println(adc.getSuitableLocationsTwo(center, 8));
    }
}