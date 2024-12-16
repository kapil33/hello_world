package interviews.twentytwentyfour.cloudera;

import java.util.HashMap;
import java.util.Map;

public class StraightLine {
    /*
    Problem statement: you are given a list of 2d points on the x-y axis. Return the max points lying on a straight line.

    arr of 2d points
    point -> (x,y)

    arr = [(0,0), (1,1), (1,2), (2,3), (2,2), (3,4) , (4,5)]

    1-> 3
    2-> 2
    3/2-> 2
    4/3-> 1
    5/4-> 1
    2/0-> 1

    Example:

    0,0 , 1,1 , 2,2. -> y = x
    answer is 3

    (1,2), (2,3), (3,4) , (4,5) -> y = x + 1
    answer is 4.

    Math.abs[(y2-y1)]/Math.abs[(x2-x1)] = slope
*/
    /*private Pair<Integer, Integer> calcSlope(int[] p1, int[] p2) {
        return new Pair<>(Math.abs(p2[1] - p1[1]), Math.abs(p2[0] - p1[0]));
    }*/

    private double calcSlope(int[] p1, int[] p2) {
        return (double) Math.abs(p2[1] - p1[1]) / Math.abs(p2[0] - p1[0]);
    }

    // TC: O(n^2)
    private int getMax(int[][] points) {
        int n = points.length, max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            Map<Double, Integer> countMap = new HashMap<>();

            for (int j=i+1; j<n; j++) {
                double slope = calcSlope(points[i], points[j]);
                countMap.put(slope, countMap.getOrDefault(slope, 0) + 1);
                System.out.println("p1=" + "{" + points[i][0] + "," + points[i][1] + "}"
                        + " , p2=" + "{" + points[j][0] + "," + points[j][1] + "}"
                        + " , slope=" + slope + " , count=" + countMap.get(slope));

                max = Math.max(max, countMap.get(slope) + 1);
            }
            System.out.println("max=" + max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0,0},{1,1},{1,2},{2,3},{2,2},{3,4},{4,5}
        };

        StraightLine ct = new StraightLine();
        System.out.println(ct.getMax(points));
    }
}
