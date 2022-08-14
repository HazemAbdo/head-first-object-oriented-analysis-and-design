package Chapter5;

public class Instrument {
    private String serialNumber;
    private double price;
    private Spec spec;
    private InstrumentType type;

    public Instrument(String _serialNumber, double _price, Spec _spec, InstrumentType _type) {
        this.serialNumber = _serialNumber;
        this.price = _price;
        this.spec = _spec;
        this.type = _type;
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

    public InstrumentType getType() {
        return type;
    }
}

// -----------------------------------------------------
// ?Guitar and Mandolin only have a constructor. That seems sort of silly.
// ?Do we really need a subclass for each type of instrument just for that?
// * we were think that but we can get rid of
// ! There’s no other way to figure out what type of instrument you’re working
// ! with than by checking the type of the class. Besides, those subclasses
// allow
// ! us to have constructors that ensure that the right type of spec is passed
// in.
// ------------------------------------------------------------------------
// public class Guitar extends Instrument {
// public Guitar(String _serialNumber, double _price, GuitarSpec _spec) {
// super(_serialNumber, _price, _spec);
// }
// }

// // -----------------------------------------------------

// public class Mandolin extends Instrument {
// public Mandolin(String _serialNumber, double _price, MandolinSpec _spec) {
// super(_serialNumber, _price, _spec);
// }
// }