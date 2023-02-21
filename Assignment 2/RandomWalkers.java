public class RandomWalkers {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int x = 0; // x coordinate
        int y = 0; // y coordinate
        int count = 0;
        double sqDistance = 0.0;

       for (int i = 0; i < trials; i++) {


           {
               while ((count) < n) {
                   // movement per step

                   double prDirection = Math.random();


                   if (prDirection < 0.25)
                   {
                       y++;
                       count++;
                   }

                   else if (prDirection >= 0.25 && prDirection < 0.50)
                   {
                       y--;
                       count++;
                   }

                   else if (prDirection >= 0.50 && prDirection < 0.75)
                   {
                       x++;
                       count++;
                   }

                   else if (prDirection >= 0.75 && prDirection < 1)
                   {
                       x--;
                       count++;
                   }
               }


               sqDistance = sqDistance + ((x * x) + (y * y));

           }
       }

       Double mean = (sqDistance/ trials);
           System.out.println("mean squared distance = "+ mean);
    }
}




