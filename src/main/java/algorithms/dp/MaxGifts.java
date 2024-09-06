package algorithms.dp;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class MaxGifts {
    /*
    * Problem Statement: A nephew found out that his uncle loves him so much, that he would do anything to
    * buy him as many gifts as he possibly can. For this reason, the nephew prepares a list of gifts
    * that he wants and gives it to his uncle.
    * Each item in the list contains 2 integers: the day on which he wants the gift (today is day 0),
    * and the cost of it. The uncle, knowing that his nephew is preparing such a list,
    * saves $1 per day for the gifts, and initially (on day 0) he has $0.
    *
    * Calculate the maximum number of gifts the uncle can buy to his nephew.
    *
    * Input: The first line contains a single integer N — the number of gifts. Then N lines follow.
    * Each line contains two integers separated by space:
    *       d_i (the day that present i should be bought) and c_i (the cost of gift i).
    * Output: A single integer which is the maximum number of gifts the uncle can buy.
    *
    * @Discussion with Nitin: https://docs.google.com/document/d/1wdfSOU_M0iLpT9WCPdNwJENk5ANPcYBxxoQr3UaQ1I4/edit#heading=h.oaulb0phtzyi
    *
    *
    * Input 1:
    * 3
    * 3 2
    * 5 4
    * 6 3
    *
    * Output 1:
    * 2
    *
    * Input 2:
    * 5
    * 1 2
    * 3 2
    * 5 3
    * 6 2
    * 7 2
    *
    * Output 2:
    * 3
    *
    * Input 3:
    * 3
    * 100 100
    * 101 5
    * 102 5
    *
    * Output 3:
    * 2
*/

    Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public int getMaxGifts(int[][] gifts, int day, int money) {
        if (day >= gifts.length)
                return 0;
        money += gifts[day][0];
        if (day > 0)
            money -= gifts[day-1][0];

        if (!map.containsKey(new Pair<>(day, money))) {
            int count = getMaxGifts(gifts, day+1, money);

            if (money >= gifts[day][1])
                count = Math.max(count, 1 + getMaxGifts(gifts, day+1, money-gifts[day][1]));

            map.put(new Pair<>(day, money), count);
        }

        return map.get(new Pair<>(day, money));
    }

    public int getMaxGifts(int[][] gifts) {
        return getMaxGifts(gifts, 0, 0);
    }

    public static void main(String[] args) {
        MaxGifts maxGifts = new MaxGifts();

        int[][] gifts = new int[][]{{3,2}, {5,4}, {6,3}};
        System.out.println(maxGifts.getMaxGifts(gifts));

        maxGifts = new MaxGifts();
        int[][] giftsTwo = new int[][]{{1,2}, {3,2}, {5,3}, {6,2}, {7,2}};
        System.out.println(maxGifts.getMaxGifts(giftsTwo));

        maxGifts = new MaxGifts();
        int[][] giftsThree = new int[][]{{100,100}, {101,5}, {102,5}};
        System.out.println(maxGifts.getMaxGifts(giftsThree));
    }
}
