package interviews.twentytwentyfour.google.previousyears;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FreeTime {
    /*
    * Problem Statement: The following is a block structure, representing a single meeting appointment:

        class block:
            person: int # Person ID
            startTime: int # Meeting Start Time
            endTime: int # Meeting End Time
        Given an array of meeting blocks for each person, need to find out time slots when everybody is free
        Time slots are in range 1 - D, and we can return 0 if there are no available slots

        Input:
        Array of blocks = [(1, 4, 5), (1, 1, 5), (2, 2, 6), (3, 8, 9), (3, 2, 4)]
        D = 10

        Output:
        Slots = [7, 10]

        Explanation
        7th hour and 10th hour is available for everyone, as no body is busy.

        Follow up : How would you find all the days where at least P people are available.
        Second follow up : find all the periods where P people are available for at least X consecutive days.
    * */

    static class Block {
        int personId;
        int startTime;
        int endTime;

        public Block(int personId, int startTime, int endTime) {
            this.personId = personId;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public List<Integer> getFreeSlots(Block[] busyTimeSlots, int d) {
        int startSlot = 1;
        List<Integer> result = new ArrayList<>();

        Arrays.sort(busyTimeSlots, (a, b)-> a.startTime - b.startTime);
        for (int i=startSlot; i<busyTimeSlots[0].startTime; i++) {
            result.add(i);
        }

        int max = busyTimeSlots[0].endTime;
        for (int i=1; i<busyTimeSlots.length; i++) {
            if (max < busyTimeSlots[i].startTime) {
                for (int j=max+1; j<busyTimeSlots[i].startTime; j++) {
                    result.add(j);
                }

                max = busyTimeSlots[i].endTime;
            } else {
                max = Math.max(max, busyTimeSlots[i].endTime);
            }
        }

        for (int i=max+1; i<=d; i++) {
            result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        //List<Block> busyTimeSlots = new ArrayList<>();
        Block[] busyTimeSlots = new Block[5];
        busyTimeSlots[0] = new Block(1,4,5);
        busyTimeSlots[1] = new Block(1,1,5);
        busyTimeSlots[2] = new Block(2,2,6);
        busyTimeSlots[3] = new Block(3,8,9);
        busyTimeSlots[4] = new Block(3,2,4);

        FreeTime ft = new FreeTime();
        System.out.println(ft.getFreeSlots(busyTimeSlots, 10));
    }
}