class NBody {

    public static void main(String[] args) {

        //command line arguments
        double tau = Double.parseDouble(args[0]); // duration of simulation
        double dt = Double.parseDouble(args[1]); // simulation time incrementa

        double t = 0.0;      // checking time
        double G = 6.67e-11; // gravitation constant

        int n = StdIn.readInt();
        double radius = StdIn.readDouble();

        double[] px = new double[n];
        double[] py = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double[] mass = new double[n];
        String[] image = new String[n];

        double[] fx = new double[n];
        double[] fy = new double[n];


        // initialising standard drawing
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
        StdDraw.enableDoubleBuffering();


        //reading universe from standard input
        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();

        }


        // playing music
        StdAudio.play("2001.wav");

        //drawing starfield back ground
        StdDraw.picture(0, 0, "starfield.jpg");

        // simulating the universe
        while (t < tau) {
            // initialising net forces to 0.0
            for (int i = 0; i < n; i++) {
                fx[i] = 0.0;
                fy[i] = 0.0;
            }

            // calculating net forces
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (i != j) {
                        double dx = px[j] - px[i];
                        double dy = py[j] - py[i];
                        double d = dx * dx + dy * dy;
                        double r = Math.sqrt(d);
                        double f = ((G * mass[i] * mass[j]) / d);
                        double cos = dx / r;
                        double sin = dy / r;
                        double fX = f * cos;
                        double fY = f * sin;

                        fx[i] = fx[i] + fX;
                        fy[i] = fy[i] + fY;

                        fx[j] = fx[j] - fX;
                        fy[j] = fy[j] - fY;

                    }
                }
            }

            // draw starfield back ground
            StdDraw.picture(0, 0, "starfield.jpg");


            // change in values
            for (int i = 0; i < n; i++) {


                double ax = fx[i] / mass[i];
                double ay = fy[i] / mass[i];

                vx[i] = vx[i] + dt * ax;
                vy[i] = vy[i] + dt * ay;

                //
                px[i] = px[i] + dt * vx[i];
                py[i] = py[i] + dt * vy[i];
                // drawing the universe
                StdDraw.picture(px[i], py[i], image[i]);


            }
            // copying off screen buffer to on screen
            StdDraw.show();
            // pausing for 1 millisecond
            StdDraw.pause(1);

            // time loop
            t = t + dt;

        }

        // printing the final state of the universe
        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    px[i], py[i], vx[i], vy[i], mass[i], image[i]);
        }

    }
}


