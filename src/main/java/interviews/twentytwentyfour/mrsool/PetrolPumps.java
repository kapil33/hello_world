package interviews.twentytwentyfour.mrsool;

import java.util.HashSet;
import java.util.Set;

public class PetrolPumps {
    /*
    * Given information about N petrol pumps (say arr[]) that are present in a circular path.
    * The information consists of the distance of the next petrol pump from the current one (in arr[i][1])
    * and the amount of petrol stored in that petrol pump (in arr[i][0]).
    * Consider a truck with infinite capacity that consumes 1 unit of petrol to travel 1 unit distance.
    * The task is to find the index of the first starting point such that the truck can visit all the petrol pumps
    * and come back to that starting point.
    * Note: Return -1 if no such tour exists.
    *
    * Input: arr[] = {{4, 6}, {6, 5}, {7, 3}, {4, 5}}.
    * Output: 1
    * Explanation: If started from 1st index then a circular tour can be covered.
    *
    * Input: arr[] = {{6, 4}, {3, 6}, {7, 3}}
    * Output: 2
    *
    * */

    /*TC: O(n^2)*/
    public int getPetrolPump(int[][] pumps) {
        int n = pumps.length;

        for(int i=0; i<n; i++) {
            int[] pump = pumps[i];
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            int fuel = pump[0], dist = pump[1];
            int j = i+1;

            while(j%n != i) {
                fuel -= dist;
                if(fuel < 0)
                    break;
                fuel += pumps[j%n][0];
                dist = pumps[j%n][1];
                visited.add(j%n);
                j++;
            }

            if(visited.size() == pumps.length && (fuel >= dist) )
                return i;
        }

        return  -1;
    }

    /*TC: O(n) [Optimized answer: https://leetcode.com/problems/gas-station/description/]*/

    public static void main(String[] args) {
        PetrolPumps pp = new PetrolPumps();
        int[][] petrolPump1 = new int[][]{{4, 6}, {6, 5}, {7, 3}, {4, 5}};
        System.out.println(pp.getPetrolPump(petrolPump1));

        int[][] petrolPump2 = new int[][]{{6, 4}, {3, 6}, {7, 3}};
        System.out.println(pp.getPetrolPump(petrolPump2));

        int[][] petrolPump3 = new int[][]{{6, 4}, {3, 6}, {3, 3}};
        System.out.println(pp.getPetrolPump(petrolPump3));

        int[][] petrolPump4 = new int[][]{{6, 4}, {3, 6}};
        System.out.println(pp.getPetrolPump(petrolPump4));
    }
}
