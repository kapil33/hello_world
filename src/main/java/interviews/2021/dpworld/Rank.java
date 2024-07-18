package interviews.dpworld;

import java.util.*;

public class Rank {
    /*Problem Statement: There are N children playing a video game.
    Their scores are recorded in a list. Then they are ranked according to their scores, top scorer being ranked 1.
    Same score guys are ranked same, so on and so forth. You are given a rank ,
    you need to output the total number of guys having equal and above that rank.

    For Example: scores = {100, 50, 50, 25}, least rank  = 3
    output: 3
    explanation: ranks are as follows{100->1, 50->2, 50->2, 25->4}
    as 100, 50, 50 are above 3, hence answer = 3
    * */

    public static int rank(List<Integer> scores, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Collections.sort(scores, Collections.reverseOrder());
        int ranks[] = new int[scores.size()];
        ranks[0] = 1;
        countMap.put(scores.get(0), countMap.getOrDefault(scores.get(0), 0)+1);

        int i=1;
        for (; i<scores.size(); i++){
            countMap.put(scores.get(i), countMap.getOrDefault(scores.get(i), 0)+1);
            if (scores.get(i) != scores.get(i-1))
                ranks[i] = ranks[i-1] + countMap.get(scores.get(i-1));
            else
                ranks[i] = ranks[i-1];
            if (ranks[i] > k)
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(rank(Arrays.asList(100,50,50,25), 3));
        System.out.println(rank(Arrays.asList(100,80,60,40,20), 4));
        System.out.println(rank(Arrays.asList(3,5,2,4,2), 4));
        System.out.println(rank(Arrays.asList(5,5,5,5,5,5,4), 1));
    }
}
