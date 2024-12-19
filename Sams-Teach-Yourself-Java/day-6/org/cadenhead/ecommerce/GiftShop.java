// Listing 6.4 The Full Text of GiftShop.java

package org.cadenhead.ecommerce;

public class GiftShop {
    public static void main(String [] arguments) {
        Storefront store = new Storefront();
        store.addItem("C01", "MUG", "9.99", "150");
        store.addItem("C02", "LG MUG", "12.99", "82");
        store.addItem("C03", "MOUSEPAD", "10.49", "800");
        store.addItem("D01", "T SHIRT", "16.99", "90");
        store.sort();

        for (int i = 0 ; i < store.getSize() ; i++ ) {
            Item show = (Item) store.getItem(i);
            System.out.println("\nItem ID: " + show.getId() +
                "\nName: " + show.getName() +
                "\nRetail Price: $" + show.getRetail() +
                "\nPrice: $" + show.getPrice() + 
                "\nQuantity: " + show.getQuantity());
        }
    }
}

// Output:
// $ java org.cadenhead.ecommerce.GiftShop

// Item ID: D01
// Name: T SHIRT
// Retail Price: $16.99
// Price: $11.89
// Quantity: 90

// Item ID: C02
// Name: LG MUG
// Retail Price: $12.99
// Price: $9.09
// Quantity: 82

// Item ID: C01
// Name: MUG
// Retail Price: $9.99
// Price: $6.99
// Quantity: 150

// Item ID: C03
// Name: MOUSEPAD
// Retail Price: $10.49
// Price: $5.25
// Quantity: 800