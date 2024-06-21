package algorithms.heaps;

import java.util.Arrays;

public class HeapSort {
    int HEAP_CAPACITY;
    int heapSize;
    int[] minHeap;

    public HeapSort(int capacity){
        minHeap = new int[capacity];
        HEAP_CAPACITY = capacity;
        heapSize = 0;
    }
    public int getParent(int i){return (i-1)/2;}
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void insertKey(int key) {
        int i = ++heapSize-1;
        minHeap[i] = key;
        while (i > 0 && minHeap[getParent(i)] > minHeap[i]){
            swap(minHeap, getParent(i), i);
            i = getParent(i);
        }
    }

    private void heapify(int i) {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left < heapSize && minHeap[left] < minHeap[smallest])
            smallest = left;
        if (right < heapSize && minHeap[right] < minHeap[smallest])
            smallest = right;
        if (i != smallest){
            swap(minHeap, i, smallest);
            heapify(smallest);
        }
    }

    public int extractMin(){
        if (heapSize == 0)
            return Integer.MAX_VALUE;
        if (heapSize == 1)
            return minHeap[--heapSize];
        int result = minHeap[0];
        minHeap[0] = minHeap[heapSize---1];
        heapify(0);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7};
        HeapSort heapSort = new HeapSort(arr.length);
        for (int num: arr){
            heapSort.insertKey(num);
        }
        int i=0;
        while (heapSort.heapSize > 0){
            arr[i++] = heapSort.extractMin();
        }
        System.out.println(Arrays.toString(arr));
    }
}
