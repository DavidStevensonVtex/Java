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

#### Accessing Array Elements

`testScore[40] = 920;`

```
float[] rating = new float[20];
rating[20] = 3.22F;
```

The compiler reports an error with these lines of code. The error occurs because the rating array does not have a slot numbered 20. It has slots 0 to 19.

Executing this Java program would stop with an `ArrayIndexOutOfBoundsException` error.

`System.out.println("Elements: " + rating.length);

#### Changing Array Elements

```
temperature[4] = 85;
day[0] = "Sunday";
manager[2] = manager[0];
```

It's important to remember than array of objects in Java is an array of references to those objects.

#### Multidimensional Arrays

Arrays can be multidimensional, containing more than one subscript to store information in multiple dimensions.

A common use of a multidimensional array to to represent the data in an (x, y) grid of array elements.

Java supports this by enabling an array to hold arrays of each of its elements.

```
int[][] dayValue = new int[52][7];
dayValue[9][0] = 14200;
```

```
int[][][] century = new int[100][52][7];
System.out.println("Elements in the first dimension: " + century.length);
System.out.println("Elements in the second dimension: " + century[0].length);
System.out.println("Elements in the third dimension: " + century[1].length);
```

#### Block Statements

Statements in Java are grouped into blocks. The beginning and ending boundaries of a block are noted with brace characters.

An important thing to note about using a block is that it creates a scope for the local variables created inside the block.

```
void testBlock() {
    int x = 10;
    {
        // start of block
        int y = 400;
        y = y + x;
    } // end of block
}
```

#### If Conditionals

```
if (arguments.length < 3) {
    System.out.println("Not enough arguments");
}
```

```
String server;
int duration;
if (arguments.length < 1) {
    server = "localhost"
} else {
    server = arguments[0];
}
```

```
int temperature = 530;
if (temperature > 660) {
    status = "returning home";
    speed = 5;
}
```

```
boolean outOfGas = true;
if (outOfGas) {
    status = "inactive";
}
```

#### Switch Conditionals

```
char grade = 'D' ;
switch (grade) {
    case 'A':
        System.out.println("Great job!");
        break;
    case 'B':
        System.out.println("Good job!");
        break;
    case 'C':
        System.out.println("You can do better!");
        break;
    default:
        System.out.println("Consider cheating!");
        break;
}
```

The test variable can be the primitive byte, char, short, or int, or as of Java 7, class String.

```
String command = "close";
switch (command) {
    case "open":
        openFile();
        break;
    case "close":
        closefile();
        break;
    default:
        System.out.println("Invalid command");
}
```

```
switch (operation) {
    case '+':
        add(object1, object2);
        break;
    case '-':
        subtract(object1, object2);
        break;
    case '*':
        multiply(object1, object2);
        break;
    case '/':
        divide(object1, object2);
        break;
}
```

Fall-through switch statements:

```
int x = 5;
switch (x) {
    case 2:
    case 4:
    case 6:
    case 8:
        System.out.println("x is an even number");
        break;
    default:
        System.out.println("x is an odd number");
}
```

### The Ternary Operator

An alternative to the if and else keywords:

`test ? trueresult : falseresult;`

`int ourBestScore = myScore > yourScore ? myScore : yourScore;`