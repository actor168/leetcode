class MyCircularQueue {

    private int[] circleQueue; //queue
    
    private int front;    //front pos
    
    private int rear;   //rear pos
    
    private int size;
    
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        size = k;
        circleQueue = new int[size];
        front = -1;
        rear = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        circleQueue[rear] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = -1;
            rear  = -1;
            return true;
        }
        front = (front + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return circleQueue[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return circleQueue[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return rear == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (front == (rear + 1) % size) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int k = 6;
        MyCircularQueue obj = new MyCircularQueue(k);
        System.out.println(obj.enQueue(6));
        System.out.println(obj.Rear());
        System.out.println(obj.Rear());
        obj.deQueue();
        boolean param_3 = obj.enQueue(5);
        System.out.println(param_3);
        System.out.println(obj.Rear());
        obj.deQueue();
        System.out.println(obj.Front());
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
    }
}