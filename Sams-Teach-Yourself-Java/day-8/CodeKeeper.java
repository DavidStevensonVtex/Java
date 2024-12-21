// Listing 8.2 The Full Text of CodeKeeper.java

import java.util.ArrayList;

import java.util.Iterator;

public class CodeKeeper {
    ArrayList<String> list;
    String[] codes = { "alpha", "lambda", "gamma", "delta", "zeta" };

    public CodeKeeper(String[] userCodes) 
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
        for (Iterator<String> ite = list.iterator(); ite.hasNext(); ) {
            String output = ite.next();
            System.out.println(output);
        }
    }

    private void addCode(String code) {
        if (!list.contains(code)) {
            list.add(code);
        }
    }

    public static void main(String[] arguments) {
        CodeKeeper keeper = new CodeKeeper(arguments);
    }
}

// $ java CodeKeeper abc def ghi jkl zeta alpha
// alpha
// lambda
// gamma
// delta
// zeta
// abc
// def
// ghi
// jkl