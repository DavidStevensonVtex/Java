// Listing 6.4 The full Text of SquareTool.java

public class SquareTool {
    public SquareTool(String input) {
        try {
            float in = Float.parseFloat(input) ;
            Square sq = new Square(in);
            float result = sq.value;
            System.out.println("The square of " + input + " is " + result);
        }
        catch ( NumberFormatException nfe) {
            System.out.println(input + " is not a valid number.");
        }
    }

    class Square {
        float value;

        Square(float x) {
            value = x * x;
        }
    }

    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java.SquareTool number");
        } else {
            SquareTool dr = new SquareTool(arguments[0]);
        }
    }
}

// Output:
// $ java SquareTool 11
// The square of 11 is 121.0