package algorithms.heaps;

public class MinHeap {
    private final int HEAP_CAPACITY;
    private int heapSize;
    int[] minHeap;

    public MinHeap(int capacity) {
        HEAP_CAPACITY = capacity;
        heapSize = 0;
        minHeap = new int[capacity];
    }

    public int getParent(int i){return (i-1)/2;}
    public int getLeftChild(int i){return 2*i+1;}
    public int getRightChild(int i){return 2*i+2;}
    public int getMin(){return minHeap[0];}
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void insertKey(int key){
        if (heapSize == HEAP_CAPACITY){
            System.out.println("Heap is full");
            return;
        }
        int i = ++heapSize-1;
        minHeap[i] = key;
        while (i > 0 && minHeap[getParent(i)] > minHeap[i]){
            swap(minHeap, getParent(i), i);
            i = getParent(i);
        }
    }

    //assumption: newKey is always less than an oldKey
    public void decreaseKey(int i, int newKey){
        minHeap[i] = newKey;
        while (i > 0 && minHeap[getParent(i)] > minHeap[i]){
            swap(minHeap, getParent(i), i);
            i = getParent(i);
        }
    }

    public int extractMin(){
        if (heapSize <= 0){
            System.out.println("Heap is empty!!");
            return Integer.MAX_VALUE;
        }
        if (heapSize == 1)
            return minHeap[--heapSize];
        int root = minHeap[0];
        minHeap[0] = minHeap[heapSize---1];
        MinHeapify(0);
        return root;
    }

    public void MinHeapify(int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int smallest = i;
        if (left < heapSize && minHeap[left] < minHeap[smallest])
            smallest = left;
        if (right < heapSize && minHeap[right] < minHeap[smallest])
            smallest = right;
        if (i != smallest){
            swap(minHeap, i, smallest);
            MinHeapify(smallest);
        }
    }

    public void deleteKey(int i){
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(11);
        minHeap.insertKey(3);
        minHeap.insertKey(2);
        minHeap.deleteKey(1);
        minHeap.insertKey(15);
        minHeap.insertKey(5);
        minHeap.insertKey(4);
        minHeap.insertKey(45);
        System.out.println("Extract min: " + minHeap.extractMin());
        System.out.println("Minimum: " + minHeap.getMin());
        minHeap.decreaseKey(2, 1);
        System.out.println("Minimum: " + minHeap.getMin());
    }
}
