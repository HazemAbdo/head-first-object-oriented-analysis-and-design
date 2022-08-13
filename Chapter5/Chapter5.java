package Chapter5;

//* Great software in 3 easy steps
// 1.Make sure your software does what the customer wants it to do
// 2.Apply basic OO principles to add flexibility
// 3.Strive for a maintainable, reusable design.
//----------------------------------------------------------------------------------------------------------------------
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Chapter5 {

    public abstract class Instrument {
        private String serialNumber;
        private double price;
        private Spec spec;

        public Instrument(String _serialNumber, double _price, Spec _spec) {
            this.serialNumber = _serialNumber;
            this.price = _price;
            this.spec = _spec;
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

        public Spec getSpec() {
            return spec;
        }
    }

    // -----------------------------------------------------
    // ?Guitar and Mandolin only have a constructor. That seems sort of silly.
    // ?Do we really need a subclass for each type of instrument just for that?
    // There’s no other way to figure out what type of instrument you’re working
    // with than by checking the type of the class. Besides, those subclasses allow
    // us to have constructors that ensure that the right type of spec is passed in.
    public class Guitar extends Instrument {
        public Guitar(String _serialNumber, double _price, GuitarSpec _spec) {
            super(_serialNumber, _price, _spec);
        }
    }

    // -----------------------------------------------------

    public class Mandolin extends Instrument {
        public Mandolin(String _serialNumber, double _price, MandolinSpec _spec) {
            super(_serialNumber, _price, _spec);
        }
    }

    // ----------------------------------------------------------------------------------------------
    public abstract class Spec {
        private Builder builder;
        private Type type;
        private Wood backWood, topWood;
        private String model;

        public Spec(String _model, Builder _builder, Type _type, Wood _backWood, Wood _topWood) {
            this.model = _model;
            this.builder = _builder;
            this.type = _type;
            this.backWood = _backWood;
            this.topWood = _topWood;
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

        private boolean matches(Spec spec2) {
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
            return true;
        }
    }

    // -----------------------------------------------------------
    public class GuitarSpec extends Spec {
        private StringNum numStrings;

        public GuitarSpec(String _model, Builder _builder, Type _type, Wood _backWood, Wood _topWood,
                StringNum _numStrings) {
            super(_model, _builder, _type, _backWood, _topWood);
            this.numStrings = _numStrings;
        }

        public StringNum getNumStrings() {
            return numStrings;
        }

        private boolean matches(GuitarSpec spec2) {
            if (!super.matches(spec2)) {
                return false;
            }
            if (!(spec2 instanceof GuitarSpec)) {
                return false;
            }
            GuitarSpec spec = (GuitarSpec) spec2;
            if (this.getNumStrings() != spec.getNumStrings()) {
                return false;
            }
            return true;
        }
    }

    // -----------------------------------------------------------
    public class MandolinSpec extends Spec {
        private Style style;

        public MandolinSpec(String _model, Builder _builder, Type _type, Wood _backWood, Wood _topWood,
                Style _style) {
            super(_model, _builder, _type, _backWood, _topWood);
            this.style = _style;
        }

        public Style getStyle() {
            return style;
        }

        private boolean matches(MandolinSpec spec2) {
            if (!super.matches(spec2)) {
                return false;
            }
            if (!(spec2 instanceof MandolinSpec)) {
                return false;
            }
            MandolinSpec spec = (MandolinSpec) spec2;
            if (this.getStyle() != spec.getStyle()) {
                return false;
            }
            return true;
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------
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

    public enum Style {
        A, B, C;

        public String toString() {
            switch (this) {
                case A:
                    return "A";
                case B:
                    return "B";
                case C:
                    return "C";
                default:
                    return "unknown";
            }
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------

    public class Inventory {
        private LinkedList<Instrument> inventory;

        public Inventory() {
            inventory = new LinkedList();
        }

        public void add(String serialNumber, double price, Spec spec) {
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
            if (spec instanceof GuitarSpec) {
                inventory.add(new Guitar(serialNumber, price, (GuitarSpec) spec));
            } else if (spec instanceof MandolinSpec) {
                inventory.add(new Mandolin(serialNumber, price, (MandolinSpec) spec));
            }
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
        public LinkedList search(GuitarSpec searchGuitarSpec) {
            LinkedList matchingGuitars = new LinkedList();
            for (Iterator i = inventory.iterator(); i.hasNext();) {
                Instrument instrument = (Instrument) i.next();
                if (instrument.getSpec().matches(searchGuitarSpec)) {
                    matchingGuitars.add(instrument);
                }
            }
            if (matchingGuitars.size() == 0) {
                return null;
            }
            return matchingGuitars;
        }

        public List search(MandolinSpec searchSpec) {
            List matchingMandolins = new LinkedList();
            for (Iterator i = inventory.iterator(); i.hasNext();) {
                Instrument instrument = (Instrument) i.next();
                if (instrument.getSpec().matches(searchSpec))
                    matchingMandolins.add(instrument);
            }
            return matchingMandolins;
        }
    }
    // ----------------------------------------------------------------------------------------------------------------------

    private static void initializeInventory(Inventory inventory) {
        GuitarSpec spec = new Chapter5().new GuitarSpec("Stratocastor", Builder.MARTIN, Type.ACOUSTIC,
                Wood.INDIAN_ROSEWOOD,
                Wood.SITKA, StringNum.EIGHT);
        inventory.add("V95693", 1299.95, spec);
        spec = new Chapter5().new GuitarSpec("Stratocastor", Builder.GIBSON, Type.ELECTRIC,
                Wood.BRAZILIAN_ROSEWOOD,
                Wood.BRAZILIAN_ROSEWOOD, StringNum.EIGHT);
        inventory.add("V9512", 1599.95, spec);
        MandolinSpec spec2 = new Chapter5().new MandolinSpec("Yamaha", Builder.ANY, Type.ACOUSTIC,
                Wood.INDIAN_ROSEWOOD,
                Wood.COCOBOLO, Style.A);
        inventory.add("UPCA-1234", 399.95, spec2);
        spec2 = new Chapter5().new MandolinSpec("Yamaha", Builder.FENDER, Type.ACOUSTIC,
                Wood.INDIAN_ROSEWOOD,
                Wood.COCOBOLO, Style.B);
        inventory.add("UPCA-5678", 299.95, spec2);
    }
    // ----------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Chapter5 app = new Chapter5();
        Inventory inventory = app.new Inventory();
        initializeInventory(inventory);
        GuitarSpec whatErinLikes = app.new GuitarSpec("Stratocastor", Builder.FENDER, Type.ACOUSTIC,
                Wood.INDIAN_ROSEWOOD,
                Wood.SITKA, StringNum.EIGHT);
        List matchingGuitars = inventory.search(whatErinLikes);
        if (matchingGuitars != null) {
            System.out.println("Erin, you might like these guitars:");
            for (Iterator i = matchingGuitars.iterator(); i.hasNext();) {
                Instrument instrument = (Instrument) i.next();
                System.out.println("Serial:" + instrument.getSerialNumber() + "    Price:" + instrument.getPrice());
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }
        MandolinSpec whatErinLikes2 = app.new MandolinSpec("Yamaha", Builder.ANY, Type.ACOUSTIC,
                Wood.INDIAN_ROSEWOOD,
                Wood.COCOBOLO, Style.B);
        List matchingMandolins = inventory.search(whatErinLikes2);
        if (matchingMandolins != null) {
            System.out.println("Erin, you might like these mandolins:");
            for (Iterator i = matchingMandolins.iterator(); i.hasNext();) {
                Instrument instrument = (Instrument) i.next();
                System.out.println("Serial:" + instrument.getSerialNumber() + "    Price:" + instrument.getPrice());
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }

    }
}
