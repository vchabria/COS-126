public class Blob {

    // instance variables
    private int pixel;
    private int xCoordinateSum;
    private int yCoordinateSum;

    // creates an empty Blob
    public Blob() {

    }

    //  adds pixel (x, y) to this blob
    public void add(int x, int y) {
        pixel++;
        xCoordinateSum += x;
        yCoordinateSum += y;
    }

    //  number of pixels added to this blob
    public int mass() {
        return pixel;
    }

    //  Euclidean distance between the
    //  center of masses of the two blobs
    public double distanceTo(Blob that) {

        //coordinate of firsy point
        double x1 = (double) xCoordinateSum / pixel;
        double y1 = (double) yCoordinateSum / pixel;

        // coordinate of second point
        double x2 = (double) that.xCoordinateSum / that.pixel;
        double y2 = (double) that.yCoordinateSum / that.pixel;

        // calculating the euclidean distance
        double euclidean = Math.sqrt(Math.pow((x2 - x1), 2)
                                             + Math.pow((y2 - y1), 2));
        return euclidean;
    }

    //  string representation of this blob
    public String toString() {
        // calculates the coordinates of the centre of
        // mass of the blob
        double x = (double) xCoordinateSum / pixel;
        double y = (double) yCoordinateSum / pixel;

        // prints the blob's centre of mass
        // and coordinates
        return String.format("%2d  (%8.4f, %8.4f)", pixel, x, y);
    }

    public static void main(String[] args) {

        // creates the first Blob
        Blob first = new Blob();
        first.add(0, 0);
        first.add(1, 0);
        first.add(0, 1);
        first.add(1, 1);

        // creates the second blob
        Blob second = new Blob();
        second.add(0, 0);
        second.add(0, 2);
        second.add(2, 0);
        second.add(2, 2);

        // prints the distance between the
        // two blobs
        double distance = (first.distanceTo(second));
        StdOut.println(distance);

        // prints the string representation
        // of the first blob
        String representation1 = first.toString();
        StdOut.println(representation1);

        // prints the string representation
        // of the second blob
        String representation2 = second.toString();
        StdOut.println(representation2);
    }
}
