// Day 3: Listing 3.2 The Full Text of PointSetter.java

import java.awt.Point ;

class PointSetter {
    public static void main(String[] arguments) {
        Point location = new Point(4, 13);

        System.out.println("Starting location: ");
        System.out.println("X equals " + location.x);
        System.out.println("Y equals " + location.y);

        System.out.println("\nMoving to (7,6)");
        location.x = 7;
        location.y = 6;

        System.out.println("\nEnding location: ");
        System.out.println("X equals " + location.x);
        System.out.println("Y equals " + location.y);        
    }
}

// Output:
// Starting location: 
// X equals 4
// Y equals 13

// Moving to (7,6)

// Ending location: 
// X equals 7
// Y equals 6