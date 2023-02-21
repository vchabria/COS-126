public class BeadTracker {

    public static void main(String args[]) {

        //takes in the minimum value for a blob to become
        // a bead
        int min = Integer.parseInt(args[0]);
        // takes in value for tau
        double tau = Double.parseDouble(args[1]);
        // takes in value for change in time
        double delta = Double.parseDouble(args[2]);
        // takes in a sequence of image files
        String[] filename = new String[args.length - 3];
        for (int i = 0; i < args.length - 3; i++) {
            filename[i] = args[i + 3];
        }
        Picture picture1;
        Picture picture2;
        Blob[] beadArray1;
        Blob[] beadArray2;
        BeadFinder bead1;
        BeadFinder bead2;

        // comparing 2 consecutive
        // image 1 and image 2 in time delta
        // using the two beads and bead arrays
        int length = filename.length - 1;
        for (int i = 0; i < length; i++) {

            // To find the closest bead and change in movement
            // To print distance of change in movement in
            // the two images

            picture1 = new Picture(filename[i]);
            picture2 = new Picture(filename[i + 1]);

            bead1 = new BeadFinder(picture1, tau);
            bead2 = new BeadFinder(picture2, tau);


            beadArray1 = bead1.getBeads(min);
            beadArray2 = bead2.getBeads(min);


            for (int j = 0; j < beadArray2.length; j++) {
                double least = Double.POSITIVE_INFINITY;
                for (int k = 0; k < beadArray1.length; k++) {
                    double distance = beadArray1[k].distanceTo(beadArray2[j]);


                    if (distance <= delta && distance < least) {
                        least = distance;
                    }
                }

                if (least != Double.POSITIVE_INFINITY && least > 0) {
                    System.out.printf("%.4f\n", least);


                }
            }
        }
    }
}


