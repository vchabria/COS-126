public class RandomWalker {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);


        int x = 0; // x coordinate
        int y = 0; // y coordinate
        int counter = 1;
        int square = 0;

        // printing the initial position
        System.out.println("(0, 0)");


        {
            while ((counter) < n ) {
                // movement per step

                double prDirection = Math.random();

                if (prDirection < 0.25)
                {
                        y++;
                    counter++;
                    System.out.println("(" + x + ", " + y + ")");
                }
                
                
                else if (prDirection >= 0.25 && prDirection < 0.50)
                {
                        y--;
                    counter++;
                    System.out.println("(" + x + ", " + y + ")");
                } 
                
                else if (prDirection >= 0.50 && prDirection < 0.75) {
                        x++;
                    counter++;
                    System.out.println("(" + x + ", " + y + ")");
                } 
                
                else if (prDirection >= 0.75 && prDirection < 1) 
                {
                        x--;
                    counter++;
                    System.out.println("(" + x + ", " + y + ")");
                }
            }


            square = (x * x) + (y * y);
            System.out.println("Squared distance = " + square);
        }
    }
}

