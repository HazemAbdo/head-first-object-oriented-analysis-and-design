package Chapter5;

//* OO Principles
//1.Encapsulate what varies.
//2.Code to an interface rather than to an implementation.
//3.Each class in your application should have only one reason to change.
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Chapter5 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.initializeInventory();
        Map properties = new HashMap();
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.SITKA);
        properties.put("numStrings", StringNum.SIX);
        Spec spec = new Spec(properties);
        LinkedList matchingInstruments = inventory.search(spec);
        for (Iterator i = matchingInstruments.iterator(); i.hasNext();) {
            Instrument instrument = (Instrument) i.next();
            System.out.println(instrument.getType());
            instrument.getSpec().print();
            System.out.println("--------------------");
        }
    }
}
