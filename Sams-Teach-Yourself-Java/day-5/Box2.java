// Listing 5.5 The Full Text of Box2.java

import java.awt.Point;

public class Box2 {
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    Box2(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    Box2(Point topLeft, Point bottomRight) {
        this (topLeft.x, topLeft.y, bottomRight.x, bottomRight.y);
    }

    Box2(Point topLeft, int w, int h) {
        this(topLeft.x, topLeft.y, topLeft.x + w, topLeft.y + h);
    }


    void printBox() {
        System.out.print("Box: <" + x1 + ", " + y1);
        System.out.println(", " + x2 + ", " + y2 + ">");
    }

    public static void main(String[] arguments) {
        Box2 rect ;

        System.out.println("Calling buildbox with coordinates (25,25) and (50,50): ");
        rect = new Box2(25, 25, 50, 50);
        rect.printBox();

        System.out.println("\nCalling buildBox with points (10, 10) and (20, 20)");
        rect = new Box2(new Point(10, 10), new Point (20, 20));
        rect.printBox();

        System.out.println("\nCalling buildBox with point(10,10), width 50 and height 50: ");
        rect = new Box2(new Point(10, 10), 50, 50);
        rect.printBox();
    }
}

// Output: 

// Calling buildbox with coordinates (25,25) and (50,50): 
// Box: <25, 25, 50, 50>

// Calling buildBox with points (10, 10) and (20, 20)
// Box: <10, 10, 20, 20>

// Calling buildBox with point(10,10), width 50 and height 50: 
// Box: <10, 10, 60, 60>