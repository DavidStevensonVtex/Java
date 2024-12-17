// Listing 5.6 The Full Text of Printer.java

public class Printer {
    int x = 0;
    int y = 1;

    void printMe() {
        System.out.println("x is " + x + ", y is " + y);
        System.out.println("I am an instance of the class " + this.getClass().getName());
    }
}

class SubPrinter extends Printer {
    int z = 3;

    public static void main(String[] arguments) {
        SubPrinter obj = new SubPrinter();
        obj.printMe();
    }
}

// Output
// x is 0, y is 1
// I am an instance of the class SubPrinter