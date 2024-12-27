// Day 3: Listing 3.3. The Full Text of StringChecker.java

class StringChecker {
    public static void main(String[] arguments) {
        String str = " Would you like an apple pie with that?" ;
        System.out.println("The string is: " + str);
        System.out.println("Length of this string: " + str.length());
        System.out.println("the character at position 6: " + str.charAt(6));
        System.out.println("The substring from 26 to 32: " + str.substring(26,32));
        System.out.println("The index of the first 'a': " + str.indexOf('a'));
        System.out.println("The index of the beginning of the substring \"IBM\": " + str.indexOf("IBM"));
        System.out.println("The string in uppercase: " + str.toUpperCase());
    }
}

// Output:

// The string is:  Would you like an apple pie with that?
// Length of this string: 39
// the character at position 6:  
// The substring from 26 to 32: ie wit
// The index of the first 'a': 16
// The index of the beginning of the substring "IBM": -1
// The string in uppercase:  WOULD YOU LIKE AN APPLE PIE WITH THAT?