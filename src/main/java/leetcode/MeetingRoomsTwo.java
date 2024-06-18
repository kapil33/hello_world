package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsTwo {
    /* Question: Given an array of meeting time intervals consisting of start
    and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

    For example, Given [[0, 30],[5, 10],[15, 20]], return 2.

    https://github.com/Seanforfun/Algorithm-and-Leetcode/blob/master/leetcode/253.%20Meeting%20Rooms%20II.md
    */

    public int getMinimumRooms(int[][] meetings) {
        if(meetings.length == 0)
            return -1;
        else if (meetings.length == 1)
            return 1;

        //int minimumRooms = 1;
        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(meetings[0]);

        for (int i=1; i<meetings.length; i++) {
            if (meetings[i][0] >= pq.peek()[1]) {
                pq.poll();
            }

            pq.add(meetings[i]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        MeetingRoomsTwo meetingRoomsTwo = new MeetingRoomsTwo();

        int[][] input1 = new int[][] {{0,30}, {5,10}, {15,20}};
        System.out.println("Minimum no. of meeting rooms required are: " + meetingRoomsTwo.getMinimumRooms(input1));

        int[][] input2 = new int[][] {{8,16}, {9,20}, {1,10}, {12,15}, {1,5}};
        System.out.println("Minimum no. of meeting rooms required are: " + meetingRoomsTwo.getMinimumRooms(input2));
    }
}
