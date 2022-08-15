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

    public void add(String serialNumber, double price, Spec spec) {
        // ? But with Instrument as an abstract class, the add becomes a real pain!
        // it’s still a fairly small price to pay to ensure that you can’t create
        // an Instrument, which really doesn’t exist in the real world
        // It does seem like parts of our code would benefit from a concrete
        // Instrument class, while other parts wouldn’t.Sometimes this means you
        // have to make a decision one way or the other, and //! accept the trade-off.
        // ! It gets worse with every new instrument type we support
        // if (spec instanceof GuitarSpec) {
        // inventory.add(new Guitar(serialNumber, price, (GuitarSpec) spec));
        // } else if (spec instanceof MandolinSpec) {
        // inventory.add(new Mandolin(serialNumber, price, (MandolinSpec) spec));
        // }
        // -----------------------------------------------------------------------------
        // *finally we find that it is better to make Instrument a concrete class
        Instrument instrument = new Instrument(serialNumber, price, spec);
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
    // ?we want to return a list of guitars that are similar to the searchGuitar
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
    // -----------------------------------------------------------------------------
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
    // * After we use map to represent properties of the instrument then
    // no need to make Spec subclasses so no need to make search func for each Spec
    public LinkedList search(Spec searchSpec) {
        LinkedList matchingInstruments = new LinkedList();
        for (Iterator i = inventory.iterator(); i.hasNext();) {
            Instrument instrument = (Instrument) i.next();
            System.out.println(instrument.getSerialNumber());
            if (instrument.getSpec().matches(searchSpec)) {
                matchingInstruments.add(instrument);
            }
        }
        return matchingInstruments;
    }

    // -----------------------------------------------------
    public void initializeInventory() {
        Map properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.COLLINGS);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.SITKA);
        this.add("11277", 3999.95,
                new Spec(properties));
        // -----------------------
        Map properties2 = new HashMap();
        properties2.put("builder", Builder.MARTIN);
        properties2.put("model", "D-18");
        properties2.put("topWood", Wood.MAHOGANY);
        properties2.put("backWood", Wood.ADIRONDACK);
        this.add("122784", 5495.95,
                new Spec(properties2));
        // -------------------------
        Map properties3 = new HashMap();
        properties3.put("builder", Builder.FENDER);
        properties3.put("model", "Stratocastor");
        properties3.put("type", Type.ELECTRIC);
        properties3.put("topWood", Wood.ALDER);
        properties3.put("backWood", Wood.ALDER);
        this.add("V95693", 1499.95,
                new Spec(properties3));
        this.add("V9512", 1549.95,
                new Spec(properties));
        // --------------------
        Map properties4 = new HashMap();
        properties4.put("instrumentType", InstrumentType.GUITAR);
        properties4.put("builder", Builder.GIBSON);
        properties4.put("model", "Les Paul");
        properties4.put("topWood", Wood.MAPLE);
        properties4.put("backWood", Wood.MAPLE);
        this.add("70108276", 2295.95,
                new Spec(properties4));
        // ---------------------
        Map properties5 = new HashMap();
        properties5.put("builder", Builder.GIBSON);
        properties5.put("model", "SG ‘61 Reissue");
        properties5.put("topWood", Wood.MAHOGANY);
        properties5.put("backWood", Wood.MAHOGANY);
        this.add("82765501", 1890.95,
                new Spec(properties5));
        // ---------------------
        Map properties7 = new HashMap();
        properties7.put("builder", Builder.GIBSON);
        properties7.put("instrumentType", InstrumentType.BANJO);
        properties7.put("model", "RB-3 Wreath");
        properties7.put("backWood", Wood.MAPLE);
        properties7.put("numStrings", 5);
        this.add("8900231", 2945.95,
                new Spec(properties7));
        // ---------------------
        Map properties6 = new HashMap();
        properties6.put("builder", Builder.GIBSON);
        properties6.put("instrumentType", InstrumentType.MANDOLIN);
        properties6.put("type", Type.ACOUSTIC);
        properties6.put("model", "F-5G");
        properties6.put("backWood", Wood.MAPLE);
        properties6.put("topWood", Wood.MAPLE);
        this.add("9019920", 5495.99,
                new Spec(properties6));
    }
}
