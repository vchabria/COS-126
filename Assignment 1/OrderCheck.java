public class OrderCheck {

    public static void main(String[] args) {
	Double x = Double.parseDouble(args[0]);
    Double y = Double.parseDouble(args[1]);
    Double z = Double.parseDouble(args[2]);
    Boolean a = ((x<y && y<z) || (x>y && y>z));
    System.out.print(a);

    }
}
