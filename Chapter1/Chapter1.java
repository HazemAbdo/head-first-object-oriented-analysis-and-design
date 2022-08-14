package Chapter1;

//* Great software in 3 easy steps
// 1.Make sure your software does what the customer wants it to do
// 2.Apply basic OO principles to add flexibility
// 3.Strive for a maintainable, reusable design.
import java.util.Iterator;
import java.util.LinkedList;

public class Chapter1 {
    public static void main(String[] args) {
        // Set up Rick’s guitar inventory
        Inventory inventory = new Inventory();
        inventory.initializeInventory();
        // ? the customer only provides you with specs so why to make a new guitar
        // ?with price and serial number that didn't used
        // we will make a guiterSpec object to hold the specs
        // just encapsulate those properties away from Guitar into a new object?
        // * Encapsulation is also about breaking your app into logical
        // * parts, and then keeping those parts separate.
        // ------------------------------------
        // There’s nothing a well-designed object hates more than being
        // used to do something that really isn’t its true purpose.
        // ! some helpful tips to start you on your search for the mismatched object
        // 1. Objects should do what their names indicate
        // 2. Each object should represent a single concept.
        // 3. Unused properties are a dead giveaway.
        // ------------------------------------
        // Guitar whatErinLikes = app.new Guitar("95128", 1700, Builder.GIBSON,
        // "Stratocastor", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD,
        // Wood.BRAZILIAN_ROSEWOOD);
        GuitarSpec whatErinLikes = new GuitarSpec("Stratocastor", Builder.GIBSON, Type.ACOUSTIC,
                Wood.BRAZILIAN_ROSEWOOD,
                Wood.BRAZILIAN_ROSEWOOD, StringNum.EIGHT);
        LinkedList matchingGuitars = inventory.search(whatErinLikes);
        if (matchingGuitars != null) {
            for (Iterator i = matchingGuitars.iterator(); i.hasNext();) {
                Guitar guitar = (Guitar) i.next();
                System.out.println("Serial:" + guitar.getSerialNumber() + "    Price:" + guitar.getPrice());
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }
    }
}
