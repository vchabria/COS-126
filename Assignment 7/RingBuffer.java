public class RingBuffer {
    double[] buffer;
    int capacity; //stores length
    int start; //stores the index of the least recently inserted item
    int end; //stores the index one beyond the most recently inserted item
    int count; //number of items in the buffer
    double result; // stores result in dequeue

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new double[capacity];
        this.start = 0;
        this.end = 0;
    }

    // returns the number of items currently in this ring buffer
    public int size() {
        return count;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        return(count == 0);
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        return(count == capacity);
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        if(isFull()) {
            throw new RuntimeException("The buffer is full");
        }
        else {
            buffer[end] = x;
            end = (end + 1) % capacity;
            count++;
        }
        }


    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("The buffer is empty");
        }
        else {
            result = buffer[start];
            start = (start + 1) % capacity;
            count--;
        }
        return result;
    }

    // returns the item at the front of this ring buffer
    public double peek() {
        if(isEmpty()) {
            throw new RuntimeException("The buffer is empty");
        }
        else {
            return(buffer[start]);
        }
    }

    // given : tests this class by directly
    // calling all instance method
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(n);
        for (int i = 1; i <= n; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        StdOut.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        StdOut.println(buffer.peek());
    }
    }


