// Day 5: Listing 5.3 The Full Text of Averager.java

public class Averager {
    public static void main(String[] arguments) {
        int sum = 0;

        if (arguments.length > 0) {
            for ( int i = 0 ; i < arguments.length ; i++ ) {
                sum += Integer.parseInt(arguments[i]);
            }
            System.out.println("sum is: " + sum);
            System.out.println("Average is: " + (float) sum / arguments.length);
        }
    }
}

// Output:
// java Averager 1 4 13
// sum is: 18
// Average is: 6.0