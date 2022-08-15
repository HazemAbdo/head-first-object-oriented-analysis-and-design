package Chapter5;


import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Chapter5 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.initializeInventory();
        Map properties = new HashMap();
        properties.put("builder", Builder.GIBSON);
        properties.put("backWood", Wood.MAPLE);
        Spec clientSpec = new Spec(properties);
        List matchingInstruments = inventory.search(clientSpec);
        if (matchingInstruments.size() > 0) {
            System.out.println("You might like these instruments:");
            for (int i = 0; i < matchingInstruments.size(); i++) {
                Instrument instrument = (Instrument) matchingInstruments.get(i);
                Spec spec = instrument.getSpec();
                System.out
                        .println("We have a " + spec.getProperty("instrumentType") + " with the following properties:");
                spec.print();
            }
        } else {
            System.out.println("Sorry, your search returned no results.");
        }
    }
}
