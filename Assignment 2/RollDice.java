public class RollDice {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int ten = 10;
        int trial = 0;
        int[] freq = new int[61];
        int six = 6;


        // rolling 10 dice n number of times
        while (trial < n) {
// sum of 10 dice
            int total = 0;
            for (int i = 0; i < ten; i++) {
                int side = (int) (Math.random() * six) + 1;
                total = total + side;
            }
            freq[total]++;
            trial++;
        }

// printing histogram
        for (int j = ten; j < freq.length; j++) {
            System.out.print(j + ": ");
            for (int k = 0; k < freq[j]; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }


    }
}
