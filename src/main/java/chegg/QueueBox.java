package chegg;

public class QueueBox<E> {
    private int QUEUE_SIZE = 5;
    private Object[] elements;
    private int front_idx, rear_idx, count;

    public QueueBox() {
        elements = new Object[QUEUE_SIZE];
        this.front_idx = 0;
        this.rear_idx = QUEUE_SIZE -1;
        this.count = 0;
    }

    //checks whether queue is empty or not
    public boolean isEmpty(){
        return count == 0;
    }

    //checks whether queue is full or not
    public boolean isFull(){
        return count == QUEUE_SIZE;
    }

    //adds an element to rear
    public void add(Object newItem) {
        if (!isFull()) {
            rear_idx = (rear_idx + 1) % QUEUE_SIZE;
            elements[rear_idx] = newItem;
            count++;
            return;
        }
        else {
            System.out.println("Queue is full. Doubling the size.");
            QUEUE_SIZE = (QUEUE_SIZE * 2); // double queue size not count 
            System.out.println("New max size is: " + QUEUE_SIZE);
            Object[] temp = new Object[QUEUE_SIZE]; // temp array
            System.arraycopy(elements, front_idx, temp, front_idx, elements.length - front_idx); // copy the elements from front_idx index to elements.length-front_idx
            if (front_idx != 0) {
                System.arraycopy(elements, 0, temp, elements.length, front_idx); // copy the elements in the range elements[0] to elements[rear_idx] into the new array
            }
            elements = temp; // set elements to temp array
            rear_idx = front_idx + count;
            elements[rear_idx] = newItem; // set new item 
            count++; // increment count
        }

    }

    //removes an element from front_idx
    public Object remove(){
        if (!isEmpty()){
            Object queuefront_idx = elements[front_idx];
            System.out.println("Element removed after DeQueuing: " + queuefront_idx.toString());
            front_idx = (front_idx+1) % QUEUE_SIZE;
            count--;
            return front_idx;
        }else
            System.out.println("Trying to dequeue from empty queue");
        return null;
    }

    //returns the head of the queue
    public Object element(){
        if (!isEmpty()) {
            return elements[front_idx];
        }
        else
            System.out.println("Trying to peek with empty queue");
        return null;
    }

    //returns size of the queue
    public int size(){
        return count;
    }

}
