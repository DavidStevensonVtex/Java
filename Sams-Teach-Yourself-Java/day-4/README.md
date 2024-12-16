# Sams Teach Yourself Java in 21 Days

## Day 4: Lists, Logic and Loops

### Arrays

To create an array in Java, you must do the following:

1. Declare a variable to hold the array.
1. Create a new array object and assign it to the array variable.
1. Store information in that array.

#### Declaring Array Variables

Examples:

```
String[] requests;
Point[] targets ;
float[] donations;
```

You can also declare an array by putting the brackes after the variable name instead of the information type:

```
String requests[] ;
Point targets[] ;
float donations[] ;
```

#### Creating Array Objects

* Use the new operator.
* Initialize the contents of the array directly.

`String[] players = new String[10];`

`int[] temps = new int[99];`

When you create an array object using new, all its slots are given an initial value (0 for numeric arrays, false for Booleans, '\0' for character arrays, and null for objects).

```
Integer[] series = new Integer[3];
series[0] = new Integer(10);
series[1] = new Integer(3);
series[2] = new Integer(5);
```

`Point[] markup = { new Point(1,5), new Point(3,3), new Point(2,3) };`

Each of the elements inside the braces must be the ame type as the variable that holds the array.

`String[] titles = { "Mr.", "Mrs.", "Ms.", "Miss", "Dr." };`

All arrays have an instance variable named `length` that holds a count of the number of elements in the array.

The first element of an array has a subscript of 0 rather than 1, so an array five elements has array slots accessed using subscripts 0 through 4.