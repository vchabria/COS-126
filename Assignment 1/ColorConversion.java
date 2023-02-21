public class ColorConversion {

    public static void main(String[] args) {
    	// enter the r,g,b values
	int r = Integer.parseInt(args[0]);
	int g = Integer.parseInt(args[1]);
	int b = Integer.parseInt(args[2]);

	Double r0 = ((double)r/255);
	Double g0 = ((double)g/255);
	Double b0 = ((double)b/255);
	//using formulae
	Double w1 = ((Math.max(r0,g0)));
	Double w = (Math.max(w1,b0));
	Double c = ((w - r0)/w);
	Double m = ((w-g0)/w);
	Double y = ((w-b0)/w);
	Double k = (1 - w) ;
    System.out.println("C= " + c + " M= " + m + " = " + y + " K= " + k);
    }
}
