import java.util.Arrays;

public class LFSR {

    int n;
    int k;
    int[] register;

    // constructor: creates an LFSR with the specified seed and tap
    public LFSR(String seed, int tap) {
        n = seed.length();
        k = tap;
        register = new int[n];
        for (int i = 0; i < n; i++) {
            register[i] = seed.charAt(i);
        }
    }


    // returns the number of bits in the LFSR.
    public int length()
    {
       int n = register.length;
        return n;
    }

    // returns bit i as 0 or 1.
    public int bitAt(int i){
         int bit_value = register[n - i - 1];
         return bit_value;
        }


    // returns a string representation of this LFSR
    public String toString() {
        int n = register.length;
        String [] stringRep = new String[n];

        for (int i = 0; i < n; i++)
        {
            stringRep[i] = String.valueOf(bitAt(i));
        }

        String stringRepresentation = Arrays.toString(stringRep);
        return stringRepresentation;
    }
    // simulates one step of this LFSR and return the new bit as 0 or 1
    public int step() {
        int bit = register[0] ^ register[n - k - 1];
        for (int i = 0; i < n - 1; i++) {
            register[i] = register[i + 1];
        }
        register[n - 1] = bit;
        return bit;
    }
    // simulates k steps of this LFSR and return the k bits as a k-bit integer
    public int generate(int k)
    {
        int generate = 0;
        int bit;
        for(int i = 0; i < k; i++)
        {
            bit = step();
            generate = generate*2 + bit;
        }
        return generate;
    }

    // tests this class by directly calling all instance methods
    public static void main(String[] args) {
        // test code
        LFSR lfsr = new LFSR("01101000010",8);
        StdOut.println(lfsr);
        StdOut.println("the length of the string is :" );
        for (int i = 0; i < 10; i++) {
            int r = lfsr.generate(5);
            StdOut.println(lfsr + " " + r);
        }
    }
}

