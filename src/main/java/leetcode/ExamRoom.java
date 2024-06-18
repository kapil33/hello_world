package leetcode;

import java.util.Arrays;

public class ExamRoom {
    int size;
    int[] seats;

    public ExamRoom(int size) {
        this.size = size;
        seats = new int[size];
        Arrays.fill(seats, 0);
    }

    public int seat() {
        return 0;
    }

    public void leave(int p) {
        seats[p] = 0;
    }

    public static void main(String[] args){
        ExamRoom room = new ExamRoom(10);
        room.seat();

        System.out.println("Seats: " + Arrays.toString(room.seats));
        System.out.println("Seats size: " + room.size);

        ExamRoom room2 = new ExamRoom(20);
        System.out.println("Seats: " + Arrays.toString(room2.seats));
        System.out.println("Seats size: " + room2.size);
    }
}
