public class GuitarHero {

    public static void main(String[] args) {

        // create guitar strings
        double CONCERT_A = 440.0; // starting frequency
        // keyboard keys to use
        String keyboardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString concert[] = new GuitarString[keyboardString.length()];
        // creates and stores succeeding frequencies
        for (int i = 0; i < keyboardString.length(); i++) {
            double s = CONCERT_A * Math.pow(2, (double) (i - 24) / 12.0);
            concert[i] = new GuitarString(s);
        }

        // input loop
        Keyboard keyboard = new Keyboard();
        while (true) {

            // check if the user has played a key and process it
            // if it has
            if (keyboard.hasNextKeyPlayed()) {

                // t key played by the user
                char key = keyboard.nextKeyPlayed();
                // finds and stores the index of the key played
                int pos = keyboardString.indexOf(key);
                if (pos != -1) {
                    concert[pos].pluck();
                }
                // shows an error message if an unknown key is played
                else {
                    StdOut.println("Incorrect key");
                }

            }

            // compute the superposition of the samples
            double sample = 0;
            for (int i = 0; i < keyboardString.length(); i++) {
                sample += concert[i].sample();
            }

            // playing the sample
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < keyboardString.length(); i++) {
                concert[i].tic();
            }
        }
    }

}
