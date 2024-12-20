// Listing 7.3 The Full Text of PrimeThreads.java

public class PrimeThreads {
    public static void main ( String[] arguments) {
        PrimeThreads pt = new PrimeThreads(arguments);
    }

    public PrimeThreads(String[] arguments) {
        PrimeFinder[] finder = new PrimeFinder[arguments.length];

        for (int i = 0 ; i < arguments.length ; i++) {
            try {
                long count = Long.parseLong(arguments[i]);
                finder[i] = new PrimeFinder(count);
                System.out.println("Looking for prime " + count);
            }
            catch (NumberFormatException nfe) {
                System.out.print("Error: " + nfe.getMessage());
            }
        }

        boolean complete = false;
        while (!complete) {
            complete = true;
            for (int j = 0 ; j < finder.length ; j++) {
                if (finder[j] == null) continue;
                if (!finder[j].finished) {
                    complete = false;
                } else {
                    displayResult(finder[j]);
                    finder[j] = null;
                }
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie) {
                // do nothing
            }
        }
    }

    private void displayResult(PrimeFinder finder) {
        System.out.println("Prime " + finder.target + " is " + finder.prime);
    }
}

// $ java PrimeThreads 1 10 100 1000
// Looking for prime 1
// Looking for prime 10
// Looking for prime 100
// Looking for prime 1000
// Prime 1 is 2
// Prime 10 is 29
// Prime 100 is 541
// Prime 1000 is 7919