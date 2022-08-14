package Chapter5;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class Inventory {
    private List inventory;

    public Inventory() {
        inventory = new LinkedList();
    }

    public void add(String serialNumber, double price, Spec spec, InstrumentType type) {
        // ? But with Instrument as an abstract class, the add becomes a real pain!
        // -----------------------------
        // it’s still a fairly small price to pay to ensure that you can’t create
        // an Instrument, which really doesn’t exist in the real world
        // -----------------------------
        // It does seem like parts of our code would
        // benefit from a concrete Instrument
        // class, while other parts wouldn’t.
        // Sometimes this means you have to make
        // a decision one way or the other, and just
        // *accept the trade-off.
        // ! It gets worse with every new instrument type we support
        Instrument instrument = new Instrument(serialNumber, price, spec, type);
        inventory.add(instrument);
    }

    public Instrument get(String serialNumber) {
        for (Iterator i = inventory.iterator(); i.hasNext();) {
            Instrument instrument = (Instrument) i.next();
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    // ! The search() situation is getting more annoying with every new instrument
    // public LinkedList search(GuitarSpec searchGuitarSpec) {
    // // ?we want to return a list of guitars that are similar to the searchGuitar
    // LinkedList matchingGuitars = new LinkedList();
    // for (Iterator i = inventory.iterator(); i.hasNext();) {
    // Instrument instrument = (Instrument) i.next();
    // if (instrument instanceof Guitar) {
    // Guitar guitar = (Guitar) instrument;
    // if (guitar.getSpec().matches(searchGuitarSpec)) {
    // matchingGuitars.add(guitar);
    // }
    // }
    // }
    // return matchingGuitars;
    // }

    // public LinkedList search(MandolinSpec searchMandolinSpec) {
    // LinkedList matchingMandolins = new LinkedList();
    // for (Integer i = 0; i < inventory.size(); i++) {
    // if (inventory.get(i) instanceof Mandolin) {
    // Mandolin mandolin = (Mandolin) inventory.get(i);
    // if (mandolin.getSpec().matches(searchMandolinSpec)) {
    // matchingMandolins.add(mandolin);
    // }
    // }
    // }
    // return matchingMandolins;
    // }
    public LinkedList search(Spec searchSpec) {
        LinkedList matchingInstruments = new LinkedList();
        for (Iterator i = inventory.iterator(); i.hasNext();) {
            Instrument instrument = (Instrument) i.next();
            if (instrument.getSpec().matches(searchSpec)) {
                matchingInstruments.add(instrument);
            }
        }
        return matchingInstruments;
    }

    // -----------------------------------------------------
    public void initializeInventory() {
        Map<String, Object> properties = new HashMap();
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.SITKA);
        properties.put("numStrings", StringNum.SIX);
        Spec spec = new Spec(properties);
        this.add("V95693", 1299.95, spec, InstrumentType.GUITAR);
        Map<String, Object> properties2 = new HashMap();
        properties2.put("builder", Builder.FENDER);
        properties2.put("model", "Stratocastor");
        properties2.put("type", Type.ELECTRIC);
        properties2.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties2.put("backWood", Wood.SITKA);
        properties2.put("numStrings", StringNum.SIX);
        Spec spec2 = new Spec(properties);
        this.add("V9512", 1599.95, spec2, InstrumentType.GUITAR);
        Map<String, Object> properties3 = new HashMap();
        properties3.put("builder", Builder.GIBSON);
        properties3.put("model", "Les Paul");
        properties3.put("type", Type.ELECTRIC);
        properties3.put("topWood", Wood.MAPLE);
        properties3.put("backWood", Wood.MAPLE);
        properties3.put("style", Style.A);
        Spec spec3 = new Spec(properties3);
        this.add("V95693", 1299.95, spec3, InstrumentType.MANDOLIN);
        Map<String, Object> properties4 = new HashMap();
        properties4.put("builder", Builder.GIBSON);
        properties4.put("model", "SG '61 Reissue");
        properties4.put("type", Type.ELECTRIC);
        properties4.put("topWood", Wood.MAPLE);
        properties4.put("backWood", Wood.MAPLE);
        properties4.put("style", Style.A);
        Spec spec4 = new Spec(properties4);
        this.add("V95693", 1299.95, spec4, InstrumentType.MANDOLIN);

    }

}