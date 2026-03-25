class MyCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Initialize the queue with given capacity
    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Insert an element into the circular queue
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    // Delete an element from the circular queue
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            // Queue becomes empty
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return true;
    }

    // Get the front item
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    // Get the last item
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }
}