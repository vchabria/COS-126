public class Transform2D {
    // List of magic numbers used
    static int    ZERO         = 0;
    static int    ONE          = 1;
    static double ONE_DOUBLE   = 1.0;
    static int    TWO          = 2;
    static double TWO_DOUBLE   = 2.0;
    static double TEN          = 10.0;
    static double FOURTY_FIVE  = 45.0;

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array)
    {
        int length = array.length;
        double [] copyArray = new double[length];
        for(int i = ZERO; i < length ; i++)
        {
            copyArray[i] = array[i];
        }
        return copyArray;
    }


    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha)
    {
        int Length = x.length;
        for(int i = ZERO; i < Length; i++)
        {
            x[i] = alpha * x[i] ;
            y[i] = alpha * y[i] ;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy)
    {
        int Length = x.length;
        for(int i = ZERO; i < Length; i++)
        {
            x[i] =  dx + x[i] ;
            y[i] =  dy + y[i] ;
        }
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta)
    {
        int Length = x.length;

        for(int i = ZERO; i < Length; i++)
        {
            double x_i = x[i];
            x[i] =   x[i]* Math.cos(Math.toRadians(theta)) - y[i]* Math.sin(Math.toRadians(theta)) ;
            y[i] =   y[i]* Math.cos(Math.toRadians(theta)) + x_i * Math.sin(Math.toRadians(theta)) ;
        }
    }
    // Tests each of the API methods by directly calling them.
    public static void main(String[] args)
    {
        StdDraw.setScale(-TEN, +TEN);
        double[] x = { ZERO, ONE, ONE, ZERO };
        double[] y = { ZERO, ZERO, TWO, ONE };
        double theta = FOURTY_FIVE;
        double alpha = TWO_DOUBLE;
        double dx = ONE_DOUBLE, dy = ONE_DOUBLE;
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.polygon(x,y);
        translate(x,y,dx,dy);
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.polygon(x,y);
        rotate(x,y,theta);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.polygon(x,y);
        scale(x,y,alpha);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.polygon(x,y);

    }
}
