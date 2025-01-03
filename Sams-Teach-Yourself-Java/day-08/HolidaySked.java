// Listing 8.1 The Full Text of HolidaySked.java

import java.util.BitSet;

public class HolidaySked {
    BitSet sked;

    public HolidaySked() {
        sked = new BitSet(365);
        int[] holiday = { 1, 15, 50, 148, 185, 246, 281, 316, 326, 359 };

        for (int i = 0; i < holiday.length; i++) {
            addHoliday(holiday[i]);
        }
    }

    public void addHoliday(int dayToAdd) {
        sked.set(dayToAdd);
    }

    public boolean isHoliday(int dayToCheck) {
        boolean result = sked.get(dayToCheck);
        return result;
    }

    public static void main(String[] arguments) {
        HolidaySked cal = new HolidaySked();
        if (arguments.length > 0) {
            try {
                int whichDay = Integer.parseInt(arguments[0]);
                if (cal.isHoliday(whichDay)) {
                    System.out.println("Day number " + whichDay + " is a holiday");
                } else {
                    System.out.println("Day number " + whichDay + " is not a holiday.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error: " + nfe.getMessage());
            }
        }
    }
}

// $ java HolidaySked 123
// Day number 123 is not a holiday.
// $ java HolidaySked 281
// Day number 281 is a holiday