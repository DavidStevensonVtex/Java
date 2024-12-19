// Listing 6.3 The Full Text of Storefront.java

package org.cadenhead.ecommerce;

import java.util.*;

public class Storefront {
    private LinkedList<Item> catalog = new LinkedList<Item>();

    public void addItem (String id, String name, String price, String quant) {

        Item it = new Item(id, name, price, quant);
        catalog.add(it);
    }

    public Item getItem(int i) {
        return catalog.get(i);
    }

    public int getSize() {
        return catalog.size();
    }

    public void sort() {
        Collections.sort(catalog);
    }
}
