// Day 3: Listing 3.4 The Full Text of RefTester.java

import java.awt.Point;

class RefTester {
    public static void main(String[] arguments) {
        Point pt1, pt2 ;
        pt1 = new Point(100, 100);
        pt2 = pt1 ;
    
        pt1.x = 200 ;
        pt1.y = 200;
        System.out.println("Point1: " + pt1.x + ", " + pt1.y);
        System.out.println("Point2: " + pt2.x + ", " + pt2.y);
    }
}

// Output:

// Point1: 200, 200
// Point2: 200, 200