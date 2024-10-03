package interviews.twentytwentyfour.lightupdata;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UniqueDataStructure {

    /*Problem Statement: Write a data structure which only takes integer values as input, it supports deletion of integer value,
    insertion of integer value, searching of integer value and returning random integer value from the data structure.
    Each operation should be O(1) or constant time.*/

    Map<Integer, Integer> map;
    int[] nums; // a List can also be used here!
    int size;

    public UniqueDataStructure() {
        map = new HashMap<>();
        nums = new int[100];
        size = -1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean insert(int num) {
        if (map.containsKey(num)) {
            System.out.println("This value already exists!");

            return false;
        } else {
            size++;
            nums[size] = num;
            map.put(num, size);

            return true;
        }
    }

    public boolean delete(int num) {
        if (!map.containsKey(num)) {
            System.out.println("This value does not exist!");

            return false;
        } else {
            int index = map.get(num);
            if (index != size) {
                swap(nums, index, size);
                map.put(nums[index], index);
            }
            size--;
            map.remove(num);

            return true;
        }
    }

    public int search(int num) {
        return map.getOrDefault(num, -1);
    }

    public int getRandomValue() {
        return nums[new Random().nextInt(size)];
    }

    public static void main(String[] args) {
        UniqueDataStructure uniqueDataStructure = new UniqueDataStructure();
        uniqueDataStructure.insert(10);
        uniqueDataStructure.insert(20);
        uniqueDataStructure.insert(30);
        uniqueDataStructure.insert(40);
        System.out.println(uniqueDataStructure.search(40));
        uniqueDataStructure.delete(20);
        uniqueDataStructure.insert(50);
        System.out.println(uniqueDataStructure.search(40));
        System.out.println(uniqueDataStructure.getRandomValue());
    }
}