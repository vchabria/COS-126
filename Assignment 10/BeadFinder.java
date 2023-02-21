import java.util.ArrayList;

public class BeadFinder {

    ArrayList<Blob> blob; // array list for blobs in the picture
    public static double tau;
    public static Picture picture;
    int width; // width of image
    int height; // height of image
    boolean[][] visited; // checks for visited pixels

    //  finds all blobs in the specified picture using luminance threshold tau
    public BeadFinder(Picture pic, double t) {
        //arraylist of all blobs in picture
        picture = pic;
        tau = t;
        blob = new ArrayList<>();
        width = picture.width();
        height = picture.height();

        visited = new boolean[width][height];

        /* loop moving from pixel left to right and
         top to bottom and checks if a pixel is visited
         if not it extracts the luminance og the pixel
         and compares it to tau to check whether it's to be
         added to the blob*/


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                while (!visited[i][j]) {
                    double luminance = Luminance.intensity(picture.get(i, j));
                    if (luminance >= tau) {
                        Blob b = new Blob();
                        blob.add(b);
                        DFS(b, i, j);
                    }
                    visited[i][j] = true;
                }
            }
        }
    }

    /* performing depth-first search with recurssion
    to check for adjacent blobs*/

    private void DFS(Blob b, int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height || visited[x][y] == true)
            return;

        visited[x][y] = true;
        double luminance = Luminance.intensity(picture.get(x, y));
        if (luminance < tau) {
            visited[x][y] = true;
            return;
        }
        visited[x][y] = true;

        DFS(b, x, y + 1); // checks for blob on top
        DFS(b, x + 1, y); // checks for blob on left
        DFS(b, x - 1, y); // checks for blob on right
        DFS(b, x, y - 1); // checks for blob on bottom
        b.add(x, y);


        return;

    }

    //  returns all beads (blobs with >= min pixels)
    public Blob[] getBeads(int min) {
        //ArrayList of all beads in the picture
        ArrayList<Blob> beads = new ArrayList<>();

        for (int i = 0; i < blob.size(); i++) {
            if (blob.get(i).mass() >= min)
                beads.add(blob.get(i));
        }
        Blob[] beadsArray = new Blob[beads.size()];
        //converts ArrayList to an Array of beads
        beadsArray = beads.toArray(beadsArray);
        return beadsArray;
    }

    //  unit tests the BeadFinder data type, as described below
    public static void main(String[] args) {
        // takes in minimum value of blobs for bead
        int min = Integer.parseInt(args[0]);
        // takes a value of tau
        tau = Double.parseDouble(args[1]);
        // takes in the picture
        String pictureInput = args[2];

        picture = new Picture(pictureInput);
        BeadFinder beadFinder = new BeadFinder(picture, tau);

        Blob[] beadsArray = beadFinder.getBeads(min);
        for (int i = 0; i < beadsArray.length; i++) {
            StdOut.println(beadsArray[i].toString());
        }
    }

}
