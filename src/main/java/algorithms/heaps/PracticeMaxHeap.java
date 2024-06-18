package algorithms.heaps;

import java.util.Arrays;

public class PracticeMaxHeap {
    private final int HEAP_CAPACITY;
    private int heapSize;
    static int[] maxHeap;

    public PracticeMaxHeap(int heapCapacity) {
        HEAP_CAPACITY = heapCapacity;
        heapSize = 0;
        maxHeap = new int[heapCapacity];
    }

    public int getMax() {
        return maxHeap[0];
    }

    public void swap(int[] maxHeap, int i, int j) {
        int temp = maxHeap[i];
        maxHeap[i] = maxHeap[j];
        maxHeap[j] = temp;
    }

    public int getParent(int i) {return (i-1)/2;}
    public int getLeftChild(int i) {return 2*i+1;}
    public int getRightChild(int i) {return 2*i+2;}

    public void insert(int key) {
        if (heapSize >= HEAP_CAPACITY) {
            System.out.println("Heap is already full!");
            return;
        }
        int i = heapSize;
        maxHeap[heapSize++] = key;
        while(i > 0 && maxHeap[i] > maxHeap[getParent(i)]) {
            swap(maxHeap, i, getParent(i));
            i = getParent(i);
        }
    }

    public static void main(String[] args) {
        // create a fully operational max heap
        // insert operation of the max heap
        // get max in the max heap
        // extract the max from the max heap

        PracticeMaxHeap practiceMaxHeap = new PracticeMaxHeap(10);
        practiceMaxHeap.insert(5);
        System.out.println(Arrays.toString(maxHeap));
        practiceMaxHeap.insert(2);
        System.out.println(Arrays.toString(maxHeap));
        practiceMaxHeap.insert(7);
        System.out.println(Arrays.toString(maxHeap));

        practiceMaxHeap.insert(3);
        System.out.println(Arrays.toString(maxHeap));
        practiceMaxHeap.insert(1);
        System.out.println(Arrays.toString(maxHeap));
        practiceMaxHeap.insert(10);
        System.out.println(Arrays.toString(maxHeap));
    }
}
