public class Art {

    // MAGIC NUMBERS USED
    static double POINT_ZERO_ZERO_ZERO_FIVE = 0.0005;
    static double POINT_ONE_FIVE = 0.15;
    static double POINT_TWO = 0.2;
    static double POINT_THREE = 0.3;
    static double POINT_SIX = 0.6;
    static double POINT_SIXFIVE = 0.65;
    static double POINT_EIGHT = 0.8;
    static double ZERO = 0;
    static int ONE = 1;
    static double TWO = 2.0;
    static double TWO_POINT_EIGHT = 2.8;
    static double THREE = 3.0;
    static double SIX = 6.0;
    static int TEN = 10;
    static int TWENTY = 20;


    // main method
    // takes an input n from the user accoding to
    // desired hair thickness
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // User input hair thickness
        paint(n);
    }


    // recursive method to draw orange hair strands
    private static void orangeHair(int n, double x, double y, double rad, double radius) {
        double BEND = Math.toRadians(TEN);
        double BRANCH = Math.toRadians(TEN);
        double RATIO = POINT_SIXFIVE;
        double cy = y + Math.sin(rad) * radius;
        double cx = x + Math.cos(rad) * radius;
        StdDraw.setScale(-TWO, +TWO);
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.setPenRadius(POINT_ZERO_ZERO_ZERO_FIVE * Math.pow(n, POINT_EIGHT));
        StdDraw.line(x, y, cx, cy);


        if (n == ZERO) return;
        orangeHair(n - ONE, cx, cy, rad + BEND - BRANCH, radius * RATIO);
        orangeHair(n - ONE, cx, cy, rad + BEND + BRANCH, radius * RATIO);
        orangeHair(n - ONE, cx, cy, rad + BEND, radius * RATIO);
    }

    // recursive method to draw red hair
    private static void redHair(int n, double x, double y, double rad, double radius) {
        double BEND = Math.toRadians(-TEN);
        double BRANCH = Math.toRadians(TEN);
        double RATIO = POINT_SIXFIVE;
        double cy = y + Math.sin(rad) * radius;
        double cx = x + Math.cos(rad) * radius;
        StdDraw.setScale(-TWO, +TWO);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(POINT_ZERO_ZERO_ZERO_FIVE * Math.pow(n, POINT_EIGHT));
        StdDraw.line(x, y, cx, cy);
        if (n == ZERO) return;

        redHair(n - ONE, cx, cy, rad + BEND - BRANCH, radius * RATIO);
        redHair(n - ONE, cx, cy, rad + BEND + BRANCH, radius * RATIO);
        redHair(n - ONE, cx, cy, rad + BEND, radius * RATIO);
    }


    // recursive mthod to draw light orange hair
    private static void lightOrangeHair(int n, double x, double y, double rad, double radius) {
        double BEND = Math.toRadians(-TWENTY);
        double BRANCH = Math.toRadians(TEN);
        double RATIO = POINT_SIXFIVE;
        double cy = y + Math.sin(rad) * radius;
        double cx = x + Math.cos(rad) * radius;
        StdDraw.setScale(-TWO, +TWO);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setPenRadius(POINT_ZERO_ZERO_ZERO_FIVE * Math.pow(n, POINT_EIGHT));
        StdDraw.line(x, y, cx, cy);
        if (n == ZERO) return;

        lightOrangeHair(n - ONE, cx, cy, rad + BEND - BRANCH, radius * RATIO);
        lightOrangeHair(n - ONE, cx, cy, rad + BEND + BRANCH, radius * RATIO);
        lightOrangeHair(n - ONE, cx, cy, rad + BEND, radius * RATIO);
    }


    // recursive method to draw yellow hair
    private static void yellowHair(int n, double x, double y, double rad, double radius) {
        double BEND = Math.toRadians(TWENTY);
        double BRANCH = Math.toRadians(TEN);
        double RATIO = POINT_SIXFIVE;
        double cy = y + Math.sin(rad) * radius;
        double cx = x + Math.cos(rad) * radius;
        StdDraw.setScale(-TWO, +TWO);
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.setPenRadius(POINT_ZERO_ZERO_ZERO_FIVE * Math.pow(n, POINT_EIGHT));
        StdDraw.line(x, y, cx, cy);
        if (n == ZERO) return;

        yellowHair(n - ONE, cx, cy, rad + BEND - BRANCH, radius * RATIO);
        yellowHair(n - ONE, cx, cy, rad + BEND + BRANCH, radius * RATIO);
        yellowHair(n - ONE, cx, cy, rad + BEND, radius * RATIO);
    }

    // method to combine the kinds of hair in various bushes
    private static void hair(int n) {
        for (double i = -POINT_SIX; i <= POINT_SIX; i = i + POINT_ONE_FIVE) {
            orangeHair(n, i, POINT_SIX, (Math.PI / TWO), POINT_THREE);
            redHair(n, i, POINT_SIX, (Math.PI / TWO), POINT_THREE);
            lightOrangeHair(n, i, POINT_SIX, (Math.PI / TWO), POINT_THREE);
            yellowHair(n, i, POINT_SIX, Math.PI / TWO, POINT_THREE);
        }
    }

    // method to display the final image with hair
    private static void paint(int n) {
        StdDraw.filledSquare(THREE, THREE, SIX);
        StdDraw.enableDoubleBuffering();
        hair(n);
        StdDraw.picture(POINT_TWO, -POINT_TWO, "ang.png", TWO_POINT_EIGHT, TWO_POINT_EIGHT);
        StdDraw.show();
    }


}

