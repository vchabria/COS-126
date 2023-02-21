public class Avogadro {

    // instance variables

    public static double ABSOLUTE_TEMPERATURE = 297;
    public static double VISCOSITY = 9.135e-4;
    public static double RADIUS = 0.5e-6;
    public static double GAS_CONSTANT = 8.31446;
    public static double DELTA = 0.5;
    public static double CONVERT = 0.175e-6;


    public static void main(String[] args) {

        // method variables
        double variance = 0.0;
        double selfDiffusionConstant = 0.0;
        double boltzmannConstant = 0.0;
        double avogadroNumber = 0.0;
        double[] displacementArray = StdIn.readAllDoubles();
        double displacement = 0.0;


        // calculating Avogadro's number and Boltzmann's
        // Constant using the provided formula
        
        for (int i = 0; i < displacementArray.length; i++) {
            displacement = displacement + Math.pow(displacementArray[i] * CONVERT, 2);
        }

        variance = displacement / (2 * displacementArray.length);

        selfDiffusionConstant = variance / (2 * DELTA);

        boltzmannConstant = (selfDiffusionConstant * 6 * Math.PI * VISCOSITY * RADIUS)
                / (ABSOLUTE_TEMPERATURE);

        avogadroNumber = GAS_CONSTANT / boltzmannConstant;


        StdOut.println(String.format("Boltzmann = %.4e", boltzmannConstant));
        StdOut.println(String.format("Avogadro  = %.4e", avogadroNumber));

    }

}

