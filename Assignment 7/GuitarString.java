public class GuitarString {

    // instance variables
    private int SAMPLING_RATE = 44100;
    private double ENERGY_DECAY_FACTOR = 0.996;
    private RingBuffer buffer;
    private int capacity;
    private int n;


    // constructor #1
    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        // creating a guitar string
        n = (int) Math.ceil(SAMPLING_RATE / frequency);
        buffer = new RingBuffer(n);
        //representing guitar at rest
        for (int i = 0; i < n; i++) {
            buffer.enqueue(0);
        }
    }

    // constructor 2
    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        capacity = init.length;
        buffer = new RingBuffer(capacity);
        // initialise values in array in the buffer
        for (int j = 0; j < capacity; j++) {
            buffer.enqueue(init[j]);
        }
    }

    // returns the number of samples in the ring buffer
    public int length() {
        int size = buffer.size();
        StdOut.print(size + "size");
        return size;
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        for (int k = 0; k < n; k++) {
            buffer.dequeue();
            buffer.enqueue(StdRandom.uniform(-0.5, 0.5));
        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        double val1 = buffer.dequeue();
        double val2 = buffer.peek();
        double new_sample = ENERGY_DECAY_FACTOR * 0.5 * (val1 + val2);
        buffer.enqueue(new_sample);

    }

    // returns the current sample
    public double sample() {
        return (buffer.peek());

    }

    // unit tests this class

    public static void main(String[] args) {
        double[] samples = { 0.2, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0, -0.1, -0.3 };
        GuitarString testString = new GuitarString(samples);
        int m = 25; // 25 tics
        for (int i = 0; i < m; i++) {
            double sample = testString.sample();
            StdOut.printf("%6d %8.4f\n", i, sample);
            testString.tic();
        }
    }


}
