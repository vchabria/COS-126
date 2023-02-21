public class Tour {

    // created a nested node class
    private class Node {
        private Point p;
        private Node next;
    }

    // to create the node list
    private int size;
    private double length;
    private Node first;

    // creates an empty tour
    public Tour() {
        first = new Node(); // stores the first node
        size = 0;
        length = 0;
    }

    // creates the 4-point tour a->b->c->d->a (for debugging)
    public Tour(Point a, Point b, Point c, Point d) {
        // reads input nodes
        first = new Node();
        Node second = new Node();
        Node third = new Node();
        Node fourth = new Node();
        // stores initial input points
        first.p = a;
        second.p = b;
        third.p = c;
        fourth.p = d;
        // stores the next input points
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        size = 4;
        // calculates the length of the entire tour
        length = a.distanceTo(b) + b.distanceTo(c)
                + c.distanceTo(d) + d.distanceTo(a);
    }

    // returns the number of points in this tour
    public int size() {
        return size;
    }

    // returns the length of this tour
    public double length() {
        return length;
    }

    // returns a string representation of this tour
    public String toString() {
        String result = "";
        Node current = first;
        // prints the points in the tour as a String
        // according to the given output type
        do {
            result += current.p.toString();
            result += '\n';
            current = current.next;
        } while (!current.equals(first));
        return result;
    }

    // draws this tour to standard drawing
    public void draw() {
        Node current = first;
        // draws lines from one node to
        // the next node as defined in tour
        do {
            current.p.draw();
            current.p.drawTo(current.next.p);
            // to continue the path from where it ended before
            // it stores the new current node as the previous
            // node in which th epath ended
            current = current.next;
        } while (!current.equals(first));

    }

    // inserts p using the nearest neighbor heuristic
    public void insertNearest(Point p) {
        // the method takes in a new point p and finds the nearest point to it
        // to add  it into the tour
        Node insert = new Node();
        Node current = first;
        // case 1 : size of tour = 0
        if (size == 0) {
            first.p = p;
            first.next = first;
            size++;
        }
        // case 2 : size of tour = 1
        else if (size == 1) {
            Node second = new Node();
            first.next = second;
            second.p = p;
            second.next = first;
            size++;
            length += 2 * first.p.distanceTo(p);
        }

        // checks the nearest point to the given point p
        // using minimum distance and stores it

        // case 3 : size of tour is more than 2
        else {
            double minimumDistance = Double.MAX_VALUE;
            do {
                double currentDistance = current.p.distanceTo(p);
                if (currentDistance < minimumDistance) {
                    minimumDistance = currentDistance;
                    insert = current;
                }
                current = current.next;
            } while (!current.equals(first));

            // adjusting length of tour with addition of p
            length -= insert.p.distanceTo(insert.next.p);
            length += minimumDistance + insert.next.p.distanceTo(p);

            // adds the new node to the tour and increases
            // the size of the tour
            Node addNewNode = new Node();
            addNewNode.p = p;
            addNewNode.next = insert.next;
            insert.next = addNewNode;
            size++;

        }

    }

    // inserts p using the smallest increase heuristic
    public void insertSmallest(Point p) {
        // the method takes in a new point p and finds the nearest point to it
        // thats keeps the tour length least to add  it into the tour
        Node insert = new Node();
        Node current = first;
        // case 1 : size of tour = 0
        if (size == 0) {
            first.p = p;
            first.next = first;
            size++;
        }
        // case 2 : size of tour = 1
        else if (size == 1) {
            Node second = new Node();
            first.next = second;
            second.p = p;
            second.next = first;
            size++;
            length += 2 * first.p.distanceTo(p);
        }

        // case 3 : size of tour is more than 2

        // finds and stores a point in the tour to the given point p
        // using minimum distance that creates minimum tour length
        else {
            double minimumIncrease = Double.MAX_VALUE;
            do {
                double delta = 0;
                delta += current.p.distanceTo(p) + current.next.p.distanceTo(p);
                delta -= current.p.distanceTo(current.next.p);
                if (delta < minimumIncrease) {
                    minimumIncrease = delta;
                    insert = current;
                }
                current = current.next;
            } while (!current.equals(first));

            // adjusting length of tour with addition of p
            length -= insert.p.distanceTo(insert.next.p);
            length += insert.p.distanceTo(p) + insert.next.p.distanceTo(p);

            // adds the new node to the tour and increases
            // the size of the tour
            Node addNewNode = new Node();
            addNewNode.p = p;
            addNewNode.next = insert.next;
            insert.next = addNewNode;
            size++;
        }

    }


    // tests this class by calling all constructors and instance methods
    public static void main(String[] args) {
        // define 4 points, corners of a square
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);

        // create the tour a -> b -> c -> d -> a
        Tour squareTour = new Tour(a, b, c, d);
        StdOut.println(squareTour);

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);

        Point e = new Point(5.0, 6.0);
        squareTour.insertSmallest(e);
        squareTour.draw();

        // print the tour length to standard output
        double length = squareTour.length();
        StdOut.println("Tour length = " + length);

        // print the size to standard output
        int size = squareTour.size();
        StdOut.println("Number of points = " + size);
        
        StdOut.println(squareTour);

        squareTour.draw();


    }
}
