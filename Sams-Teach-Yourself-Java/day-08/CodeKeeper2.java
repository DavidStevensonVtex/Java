// Listing 8.4 The Full Text of CodeKeeper2.java

import java.util.ArrayList;

public class CodeKeeper2 {
    ArrayList<String> list;
    String[] codes = { "alpha", "lambda", "gamma", "delta", "zeta" };

    public CodeKeeper2(String[] userCodes) 
    {
        list = new ArrayList<String>();

        // load built-in codes
        for (int i = 0 ; i < codes.length ; i++ ) {
            addCode(codes[i]);
        }

        // Load user codes
        for (int i = 0 ; i < userCodes.length ; i++ ) {
            addCode(userCodes[i]);
        }

        // display all codes
        // for (Iterator<String> ite = list.iterator(); ite.hasNext(); ) {
        //     String output = ite.next();
        //     System.out.println(output);
        // }

        // A simpler way to loop over the array list
        for (String output : list) {
            System.out.println(output);
        }
    }

    private void addCode(String code) {
        if (!list.contains(code)) {
            list.add(code);
        }
    }

    public static void main(String[] arguments) {
        CodeKeeper2 keeper = new CodeKeeper2(arguments);
    }
}

// $ java CodeKeeper2 abc def ghi jkl zeta alpha
// alpha
// lambda
// gamma
// delta
// zeta
// abc
// def
// ghi
// jkl