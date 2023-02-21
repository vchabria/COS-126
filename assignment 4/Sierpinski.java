
public class Sierpinski {

    // magic numbers used
    static int ZERO = 0;
    static double ZERO_DOUBLE = 0.0;
    static double POINT_FIVE = 0.5;
    static int ONE = 1;
    static double ONE_DOUBLE = 1.0;
    static int TWO = 2;
    static int THREE = 3;


    public static void main(String[] args) {
        //takes the level of sierpinski to draw
        int n = Integer.parseInt(args[ZERO]);
        // draws the outer most layer
        double [] x = {ZERO_DOUBLE, ONE_DOUBLE, POINT_FIVE, ZERO_DOUBLE };
        double [] y = { ZERO_DOUBLE, ZERO_DOUBLE,Math.sqrt(THREE)/TWO,ZERO_DOUBLE};
        StdDraw.polygon(x,y);
        sierpinski(n, POINT_FIVE, ZERO_DOUBLE, POINT_FIVE);
        }


        // method to calculate height
    public static double height(double s)
    {
        double h = ((s*Math.sqrt(THREE))/TWO);
        return h;
    }

    // function to print a filled triangle
    public static void filledTriangle(double x, double y, double length)
    {
        double [] xTriangle = new double[THREE];
        double [] yTriangle = new double[THREE];
        double h = height(length);
        // plotting the polygon made by the points below
         xTriangle[ZERO] = x;
         yTriangle[ZERO] = y;
         xTriangle[ONE] = x - (length/TWO);
         yTriangle[ONE] = y + h;
         xTriangle[TWO] = x + (length/TWO);
         yTriangle[TWO]= y + h;
         StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.filledPolygon(xTriangle, yTriangle);
    }

    // recursive function to draw a sierpinski
    public static void sierpinski(int n, double x, double y, double length)
    {

       if (n==ZERO) return;

        filledTriangle(x,y,length);

        sierpinski(n-ONE,x, y+height(length),length/TWO);
        sierpinski(n-ONE, x - (length/TWO) , y ,length / TWO);
        sierpinski(n-ONE, x+(length/TWO), y , length/TWO);


    }
}

