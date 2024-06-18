package algorithms.heaps;

/*Given a running stream of numbers provide the Kth largest number with each insert.


        Input - { 10, 2, 4, 5, 20, 100, 7, ...}
        K = 3

        Output - { _, _, 2, 4, 5, 10, 10, ...}
*/

//using minHeap
public class KthLargestUnsortedArray {
    private final int HEAP_CAPACITY;
    private int heapSize;
    int[] minHeap;

    public KthLargestUnsortedArray(int capacity) {
        HEAP_CAPACITY = capacity;
        heapSize = 0;
        minHeap = new int[capacity];
    }

    public int getParent(int i){return (i-1)/2;}
    public int getLeftChild(int i){return 2*i+1;}
    public int getRightChild(int i){return 2*i+2;}
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int getKthLargest(){return minHeap[0];}

    public void insertKey(int key){
        if (heapSize == HEAP_CAPACITY){
            if (key > minHeap[0]) {
                minHeap[0] = key;
                minHeapify(0);
            }
        }
        else {
            int i = ++heapSize-1;
            minHeap[i] = key;
            while (i > 0 && minHeap[getParent(i)] > minHeap[i]){
                swap(minHeap, getParent(i), i);
                i = getParent(i);
            }
        }
    }

    private void minHeapify(int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int smallest = i;
        if (left < heapSize && minHeap[left] < minHeap[smallest])
            smallest = left;
        if (right < heapSize && minHeap[right] < minHeap[smallest])
            smallest = right;
        if (i != smallest){
            swap(minHeap, i, smallest);
            minHeapify(smallest);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12,3,5,7,19};
        KthLargestUnsortedArray kthLargestUnsortedArray = new KthLargestUnsortedArray(3);
        for (int num: nums)
            kthLargestUnsortedArray.insertKey(num);
        System.out.println("Kth largest element: " + kthLargestUnsortedArray.getKthLargest());
    }
}
