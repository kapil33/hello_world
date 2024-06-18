package leetcode;

import java.util.Arrays;
import java.util.List;

public class MinimumSumPathTriangle {

    //2 ways of doing it,
    // i.) either change the list of list(e.g. triangle) itself
    // ii.) or you can declare an array to store values (e.g. result)
    public int pathSum(List<List<Integer>> triangle){
        int row = triangle.size();
        int[] result = new int[triangle.get(row-1).size()];

        for (int i=0; i<triangle.get(row-1).size(); i++)
            result[i] = triangle.get(row-1).get(i);

        for(int i=row-2; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                List<Integer> temp = triangle.get(i);
                System.out.println("temp: " + temp);
                /*triangle.get(i).set(j,
                        triangle.get(i).get(j)
                                + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));*/
                result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j+1]);
            }
        }

        return result[0];
    }

    public static void main(String[] args){
        MinimumSumPathTriangle sum = new MinimumSumPathTriangle();
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3));

        System.out.println(sum.pathSum(triangle));
    }
}
