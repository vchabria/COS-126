import java.awt.Color;

public class PhotoMagic {
    // returns a new picture that has a transformed
    // copy of the given picture, using the given lfsr.
    public static Picture transform(Picture picture, LFSR lfsr) {
        int width = picture.width(); // width of the image
        int height = picture.height(); // height of the image
        Picture coded_picture = new Picture(width, height);

        //extracting the colours of each pixel
        // columns of the image
        for (int i = 0; i < width; i++) {
            // row of the image
            for (int j = 0; j < height; j++) {
                // extracting single colours
                Color color = picture.get(i, j);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                // creating the new colour using XOR
                int r_code = lfsr.generate(8);
                r = r ^ r_code;
                int g_code = lfsr.generate(8);
                g = g ^ g_code;
                int b_code = lfsr.generate(8);
                b = b ^ b_code;

                // the new image
                coded_picture.set(i, j, new Color(r, g, b));
            }
        }
        return coded_picture;
    }

    // takes the name of an image file and a
    // description of an lfsr as command-line arguments;
    // displays a copy of the image that is "encrypted" using the LFSR.

    public static void main(String[] args) {
        // inputs from the user
        Picture picture = new Picture(args[0]);
        String seed = args[1];
        int tap = Integer.parseInt(args[2]);
        //show the new image
        LFSR lfsr = new LFSR(seed, tap);
        transform(picture, lfsr).show();
    }
}
