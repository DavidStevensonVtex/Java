// Listing 3.1 The Full Text of TokenTester.java

import java.util.StringTokenizer ;

class TokenTester
{
    public static void main(String[] arguments) {
        StringTokenizer st1, st2 ;

        String quote1 = "GOOG 604.43 -0.42" ;
        st1 = new StringTokenizer(quote1);
        System.out.println("Token 1: " + st1.nextToken());
        System.out.println("Token 2: " + st1.nextToken());
        System.out.println("Token 3: " + st1.nextToken());
        
        String quote2 = "RHT@60.39@0.78";
        st2 = new StringTokenizer(quote2, "@");
        System.out.println("\nToken 1: " + st2.nextToken());
        System.out.println("Token 2: " + st2.nextToken());
        System.out.println("Token 3: " + st2.nextToken());
    }
}

// Output:
// Token 1: GOOG
// Token 2: 604.43
// Token 3: -0.42

// Token 1: RHT
// Token 2: 60.39
// Token 3: 0.78