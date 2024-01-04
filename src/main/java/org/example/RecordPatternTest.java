package org.example;

public class RecordPatternTest {
    record Point(int x, int y) {
    }

    static int preJava21(Point obj) {
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            return x + y;  //Prints 3
        }
        return 0; // return 0 by default
    }

    /*
    The record patterns eliminate the declaration of local variables for extracted components and
    initialize the components by invoking the accessor methods when a value is matched against the pattern
     */
    static int postJava21(Point obj) {
        if (obj instanceof Point(int x, int y)) {
            return x + y;
        }
        return 0; // return 0 by default
    }

    public static void main(String[] args) {
        Point obj = new Point(1, 2);
        System.out.println("Calling pre java21 logic" + preJava21(obj));
        System.out.println("Calling post java21 logic" + postJava21(obj));
    }
}