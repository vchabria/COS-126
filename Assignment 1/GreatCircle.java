public class GreatCircle {

    public static void main(String[] args) {
	double x1 = Double.parseDouble(args[0]);
	double y1 = Double.parseDouble(args[1]);
	double x2 = Double.parseDouble(args[2]);
	double y2 = Double.parseDouble(args[3]);
	double d1 = Math.sin(Math.toDegrees(x1)) * Math.sin(Math.toDegrees(x2));
	double d2 = Math.cos(Math.toDegrees(x1))*Math.cos(Math.toDegrees(x2)) *Math.cos(Math.toDegrees(y1-y2));
	double d = Math.toRadians(60) * Math.acos(d1+d2);
	System.out.println(d);
    }
}
