package algorithms.heaps;

public class MaxHeap {
    private final int HEAP_CAPACITY;
    private int heapSize;
    int[] maxHeap;

    public MaxHeap(int capacity) {
        HEAP_CAPACITY = capacity;
        heapSize = 0;
        maxHeap = new int[capacity];
    }

    public int getParent(int i){return (i-1)/2;}
    public int getLeftChild(int i){return 2*i+1;}
    public int getRightChild(int i){return 2*i+2;}
    public int getMax(){return maxHeap[0];}
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
        maxHeap[i] = key;
        while (i > 0 && maxHeap[getParent(i)] < maxHeap[i]){
            swap(maxHeap, getParent(i), i);
            i = getParent(i);
        }
    }

    //assumption: newKey is always less than an oldKey
    public void decreaseKey(int i, int newKey){
        maxHeap[i] = newKey;
        while (i > 0 && maxHeap[getParent(i)] < maxHeap[i]){
            swap(maxHeap, getParent(i), i);
            i = getParent(i);
        }
    }

    public int extractMax(){
        if (heapSize <= 0){
            System.out.println("Heap is empty!!");
            return Integer.MIN_VALUE;
        }
        if (heapSize == 1)
            return maxHeap[--heapSize];
        int root = maxHeap[0];
        maxHeap[0] = maxHeap[heapSize---1];
        maxHeapify(0);
        return root;
    }

    public void maxHeapify(int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int largest = i;
        if (left < heapSize && maxHeap[left] > maxHeap[largest])
            largest = left;
        if (right < heapSize && maxHeap[right] > maxHeap[largest])
            largest = right;
        if (i != largest){
            swap(maxHeap, i, largest);
            maxHeapify(largest);
        }
    }

    public void deleteKey(int i){
        decreaseKey(i, Integer.MAX_VALUE);
        extractMax();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(11);
        maxHeap.insertKey(3);
        maxHeap.insertKey(2);
        maxHeap.deleteKey(1);
        maxHeap.insertKey(15);
        maxHeap.insertKey(5);
        maxHeap.insertKey(4);
        maxHeap.insertKey(45);
        System.out.println("Extract min: " + maxHeap.extractMax());
        System.out.println("Maximum: " + maxHeap.getMax());
        maxHeap.decreaseKey(2, 1);
        System.out.println("Maximum: " + maxHeap.getMax());
    }
}
