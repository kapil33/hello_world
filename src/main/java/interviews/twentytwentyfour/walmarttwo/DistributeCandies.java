package interviews.twentytwentyfour.walmarttwo;

import java.util.Arrays;

public class DistributeCandies {
    /*
    * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

* https://leetcode.com/problems/candy/description/

Input: ratings = [1,0,2] -> [2,1,2] -> 5

Input: ratings = [1,2,2] -> [1,2,1] -> 4

*
* Pseudo Code:
* 1. find min rating child & assign 1 candy
* 2. then recursively visit neighbours and assign candies accordingly
*
* [1,0,2]-> index=2 -> recur(1) & recur(3)
* visited[false,true,false]
*
* [0,1,2,3,4,5]->
* index=0, candy=1, recur(-1) & recur(1)
* candies[1,0,0,0,0,0]
* visited[1,0,0,0,0,0]
*
* recur(1):
* candies[1,2,0,0,0,0]
* visited[1,1,0,0,0,0]
* recur(0) & recur(2)
*
*
* [10,9,8,7,6]: [2,1]-> [3,2,1]
*
* [1,2,3,4,5,0,3,1,2,1,9,8,7,6,10,0,8]
* [1,2,3,4,5,1,2,1,2,1,4,3,2,1,2,1,2]
*
* [0,1,2,3,4,5]: [1,2,3,4,5,6]
    * */

    private int getMinimumCandies(int[] ratings) {
        int n = ratings.length, sum = 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1]+1;
        }
        for(int i=n-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i+1]+1);
        }

        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        DistributeCandies dc = new DistributeCandies();
        System.out.println(dc.getMinimumCandies(new int[]{1, 0, 2})); //5
        System.out.println(dc.getMinimumCandies(new int[]{1, 2, 2})); // 4
        System.out.println(dc.getMinimumCandies(new int[]{1, 3, 4, 5, 2})); // 11
    }

}
