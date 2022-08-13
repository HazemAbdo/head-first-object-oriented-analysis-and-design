package Chapter1;

//* Great software in 3 easy steps
// 1.Make sure your software does what the customer wants it to do
// 2.Apply basic OO principles to add flexibility
// 3.Strive for a maintainable, reusable design.
//----------------------------------------------------------------------------------------------------------------------
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Chapter1 {
    // ? what we benefit from using enums
    // One of the big advantages of using enums is that it limits the possible
    // values you can supply to a method...no more misspellings or case issues.
    // * not only type safety, but value safety
    public enum Type {
        ACOUSTIC, ELECTRIC;

        public String toString() {
            switch (this) {
                case ACOUSTIC:
                    return "acoustic";
                case ELECTRIC:
                    return "electric";
                default:
                    return "unknown";
            }
        }
    }

    public enum Builder {
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

        public String toString() {
            switch (this) {
                case FENDER:
                    return "fender";
                case MARTIN:
                    return "martin";
                case GIBSON:
                    return "gibson";
                case COLLINGS:
                    return "collings";
                case OLSON:
                    return "olson";
                case RYAN:
                    return "ryan";
                case PRS:
                    return "prs";
                case ANY:
                    return "any";
                default:
                    return "unknown";
            }
        }
    }

    public enum Wood {
        INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

        public String toString() {
            switch (this) {
                case INDIAN_ROSEWOOD:
                    return "Indian_Rosewood";
                case BRAZILIAN_ROSEWOOD:
                    return "Brazilian_Rosewood";
                case MAHOGANY:
                    return "Mahogany";
                case MAPLE:
                    return "Maple";
                case COCOBOLO:
                    return "Cocobolo";
                case CEDAR:
                    return "Cedar";
                case ADIRONDACK:
                    return "Adirondack";
                case ALDER:
                    return "Alder";
                case SITKA:
                    return "Sitka";
                default:
                    return "unknown";
            }
        }
    }

    public enum StringNum {
        FIVE, SIX, SEVEN, EIGHT, NINE, TWELVE;

        public Integer toInteger() {
            switch (this) {
                case FIVE:
                    return 5;
                case SIX:
                    return 6;
                case SEVEN:
                    return 7;
                case EIGHT:
                    return 8;
                case NINE:
                    return 9;
                case TWELVE:
                    return 12;
                default:
                    return 5;
            }
        }
    }

    // -----------------------------------------------------
    // ! We’re adding a property to GuitarSpec(numStrings), but we
    // ! have to change code in the Inventory class’s
    // ! search() method, as well as in the constructor
    // ! to the Guitar class
    // * Encapsulation to the rescue!
    public class GuitarSpec {
        // ?why model still sting not enum
        // we left model as a String since there are thousands of different guitar
        // models out there... way too many for an enum to be helpful
        private String model;
        private Builder builder;
        private Type type;
        private Wood backWood, topWood;
        private StringNum numStrings;

        public GuitarSpec(String _model, Builder _builder, Type _type, Wood _backWood, Wood _topWood,
                StringNum _numStrings) {
            this.model = _model;
            this.builder = _builder;
            this.type = _type;
            this.backWood = _backWood;
            this.topWood = _topWood;
            this.numStrings = _numStrings;
        }

        public Builder getBuilder() {
            return builder;
        }

        public String getModel() {
            return model;
        }

        public Type getType() {
            return type;
        }

        public Wood getBackWood() {
            return backWood;
        }

        public Wood getTopWood() {
            return topWood;
        }

        public StringNum getNumStrings() {
            return numStrings;
        }

        private boolean areSimilarGuitars(GuitarSpec spec2) {
            if (this.getBuilder() != spec2.getBuilder()) {
                return false;
            }
            if (!this.getModel().toLowerCase().equals(spec2.getModel().toLowerCase())) {
                return false;
            }
            if (this.getType() != spec2.getType()) {
                return false;
            }
            if (this.getBackWood() != spec2.getBackWood()) {
                return false;
            }
            if (this.getTopWood() != spec2.getTopWood()) {
                return false;
            }
            if (this.getNumStrings() != spec2.getNumStrings()) {
                return false;
            }
            return true;
        }
    }
    // -----------------------------------------------------

    public class Guitar {
        private String serialNumber;
        private double price;
        private GuitarSpec spec;

        public Guitar(String _serialNumber, double _price,
                GuitarSpec _Spec) {
            this.serialNumber = _serialNumber;
            this.price = _price;
            this.spec = _Spec;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double newPrice) {
            this.price = newPrice;
        }

        public GuitarSpec getSpec() {
            return spec;
        }

    }

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
    }
    // ----------------------------------------------------------------------------------------------------------------------

    private static void initializeInventory(Inventory inventory) {
        GuitarSpec spec = new Chapter1().new GuitarSpec("Stratocastor", Builder.FENDER, Type.ACOUSTIC,
                Wood.INDIAN_ROSEWOOD,
                Wood.SITKA, StringNum.EIGHT);
        inventory.addGuitar("V95693", 1299.95, spec);
        spec = new Chapter1().new GuitarSpec("Stratocastor", Builder.GIBSON, Type.ACOUSTIC,
                Wood.BRAZILIAN_ROSEWOOD,
                Wood.BRAZILIAN_ROSEWOOD, StringNum.EIGHT);
        inventory.addGuitar("V9512", 1599.95, spec);
    }
    // ----------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        // Set up Rick’s guitar inventory
        Chapter1 app = new Chapter1();
        Inventory inventory = app.new Inventory();
        initializeInventory(inventory);
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
        GuitarSpec whatErinLikes = app.new GuitarSpec("Stratocastor", Builder.GIBSON, Type.ACOUSTIC,
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
