// Day 5: Listing 5.2 The Full Text of Passer.java

public class Passer {
    void toUpperCase(String[] text) {
        for (int i = 0; i < text.length ; i++) {
            text[i] = text[i].toUpperCase();
        }
    }

    public static void main(String[] arguments) {
        Passer passer = new Passer();
        passer.toUpperCase(arguments);
        for (int i = 0 ; i < arguments.length ; i++) {
            System.out.print(arguments[i] + " " );
        }
        System.out.println();
    }
}

// Output:
// java Passer abc def ghi
// ABC DEF GHI 