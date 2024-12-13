// Day 3: Listing 3.5 The Full Text of the EqualsTester.java

class EqualsTester {
    public static void main(String[] arguments) {
        String str1, str2;
        str1 = "Free the bound periodicals.";
        str2 = str1;

        System.out.println("String1: " + str1);
        System.out.println("String2: " + str2);
        System.out.println("Same object? " + (str1 == str2));

        str2 = new String(str1);
        System.out.println("String1: " + str1);
        System.out.println("String2: " + str2);
        System.out.println("Same object? " + (str1 == str2));      
        System.out.println("Same value? " + (str1.equals(str2)));      
    }
}

// Output:

// String1: Free the bound periodicals.
// String2: Free the bound periodicals.
// Same object? true
// String1: Free the bound periodicals.
// String2: Free the bound periodicals.
// Same object? false
// Same value? true