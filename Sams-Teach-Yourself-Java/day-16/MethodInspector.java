// Listing 16.3 The Full Text of MethodInspector.java

import java.lang.reflect.*;

public class MethodInspector {
    public static void main(String[] arguments) {
        Class inspect;
        try {
            if (arguments.length > 0) {
                inspect = Class.forName(arguments[0]);
            }
            else
            {
                inspect = Class.forName("MethodInspector");
            }

            Method[] methods = inspect.getDeclaredMethods();
            for (int i = 0 ; i < methods.length ; i++) {
                Method methVal = methods[i];
                Class returnVal = methVal.getReturnType();
                int mods = methVal.getModifiers();
                String modVal = Modifier.toString(mods);
                Class[] paramVal = methVal.getParameterTypes();
                StringBuffer params = new StringBuffer();
                for (int j = 0 ; j < paramVal.length; j++) {
                    if (j > 0)
                    {
                        params.append(", ");
                    }
                    params.append(paramVal[j].getName());
                }

                System.out.println("Method: " + methVal.getName());
                System.out.println("Modifiers: " + modVal);
                System.out.println("Return Type: " + returnVal.getName());
                System.out.println("Parameters: " + params + "\n");
            }
        }
        catch (ClassNotFoundException c) {
            System.out.println(c.toString());
        }
    }
}

// $ java MethodInspector java.util.Random
// Method: next
// Modifiers: protected
// Return Type: int
// Parameters: int

// Method: readObject
// Modifiers: private
// Return Type: void
// Parameters: java.io.ObjectInputStream

// Method: writeObject
// Modifiers: private synchronized
// Return Type: void
// Parameters: java.io.ObjectOutputStream

// Method: nextInt
// Modifiers: public
// Return Type: int
// Parameters: int

// Method: nextInt
// Modifiers: public
// Return Type: int
// Parameters: 

// Method: nextDouble
// Modifiers: public
// Return Type: double
// Parameters: 

// Method: seedUniquifier
// Modifiers: private static
// Return Type: long
// Parameters: 

// Method: initialScramble
// Modifiers: private static
// Return Type: long
// Parameters: long

// Method: setSeed
// Modifiers: public synchronized
// Return Type: void
// Parameters: long

// Method: nextBytes
// Modifiers: public
// Return Type: void
// Parameters: [B

// Method: internalNextLong
// Modifiers: final
// Return Type: long
// Parameters: long, long

// Method: internalNextInt
// Modifiers: final
// Return Type: int
// Parameters: int, int

// Method: internalNextDouble
// Modifiers: final
// Return Type: double
// Parameters: double, double

// Method: nextLong
// Modifiers: public
// Return Type: long
// Parameters: 

// Method: nextBoolean
// Modifiers: public
// Return Type: boolean
// Parameters: 

// Method: nextFloat
// Modifiers: public
// Return Type: float
// Parameters: 

// Method: nextGaussian
// Modifiers: public synchronized
// Return Type: double
// Parameters: 

// Method: ints
// Modifiers: public
// Return Type: java.util.stream.IntStream
// Parameters: long

// Method: ints
// Modifiers: public
// Return Type: java.util.stream.IntStream
// Parameters: 

// Method: ints
// Modifiers: public
// Return Type: java.util.stream.IntStream
// Parameters: int, int

// Method: ints
// Modifiers: public
// Return Type: java.util.stream.IntStream
// Parameters: long, int, int

// Method: longs
// Modifiers: public
// Return Type: java.util.stream.LongStream
// Parameters: 

// Method: longs
// Modifiers: public
// Return Type: java.util.stream.LongStream
// Parameters: long

// Method: longs
// Modifiers: public
// Return Type: java.util.stream.LongStream
// Parameters: long, long

// Method: longs
// Modifiers: public
// Return Type: java.util.stream.LongStream
// Parameters: long, long, long

// Method: doubles
// Modifiers: public
// Return Type: java.util.stream.DoubleStream
// Parameters: 

// Method: doubles
// Modifiers: public
// Return Type: java.util.stream.DoubleStream
// Parameters: long

// Method: doubles
// Modifiers: public
// Return Type: java.util.stream.DoubleStream
// Parameters: long, double, double

// Method: doubles
// Modifiers: public
// Return Type: java.util.stream.DoubleStream
// Parameters: double, double

// Method: resetSeed
// Modifiers: private
// Return Type: void
// Parameters: long