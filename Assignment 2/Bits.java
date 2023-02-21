public class Bits {

    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	int copy = n;
	int counter = 0;
    int divisor = 2;

        // dividing by 2 until its strictly lesser than 1
        while (copy>0)
            {
                copy = copy / divisor ;
                counter++;
            }
            System.out.print(counter);
        }
    }

