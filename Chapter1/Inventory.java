package Chapter1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// ----------------------------------------------------------------------------------------------------------------------
public class Inventory {
    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
    }

    public void addGuitar(String serialNumber, double price,
            GuitarSpec spec) {
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            Guitar guitar = (Guitar) i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    // areSimilarGuitarsWasHere
    // but we move it so that we don't need to change the Inventory class
    // when we make a change in the GuitarSpec class
    // * Delegation
    // is when an object needs to perform a certain task, and instead of doing that
    // task directly, it asks another one to handle the (or sometimes just a part)
    // * Loosely coupled
    // is when the objects in your application each have a specific job to do,
    // and they do only that job.
    public LinkedList search(GuitarSpec searchGuitarSpec) {
        // ?we want to return a list of guitars that are similar to the searchGuitar
        LinkedList matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            Guitar guitar = (Guitar) i.next();
            if (guitar.getSpec().areSimilarGuitars(searchGuitarSpec)) {
                matchingGuitars.add(guitar);
            }
        }
        if (matchingGuitars.size() == 0) {
            return null;
        }
        return matchingGuitars;
    }

    // ---------------------------------------------------------
    public void initializeInventory() {
        GuitarSpec spec = new GuitarSpec("Stratocastor", Builder.FENDER, Type.ACOUSTIC,
                Wood.INDIAN_ROSEWOOD,
                Wood.SITKA, StringNum.EIGHT);
        this.addGuitar("V95693", 1299.95, spec);
        spec = new GuitarSpec("Stratocastor", Builder.GIBSON, Type.ACOUSTIC,
                Wood.BRAZILIAN_ROSEWOOD,
                Wood.BRAZILIAN_ROSEWOOD, StringNum.EIGHT);
        this.addGuitar("V9512", 1599.95, spec);
    }
}
