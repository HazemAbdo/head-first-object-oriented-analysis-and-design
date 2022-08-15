package Chapter5;

public class Instrument {
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
// !There’s no other way to figure out what type of instrument you’re working
// !with than by checking the type of the class. Besides, those subclasses
// !allow us to have constructors ensure that the right type of spec is passed
// *--------- we were thinking that but in fact we can get rid of----------
// * Guitar and Mandolin and the other instruments don’t have different behavior.But they have different properties
// ------------------------------------------------------------------------
// public class Guitar extends Instrument {
// public Guitar(String _serialNumber, double _price, GuitarSpec _spec) {
// super(_serialNumber, _price, _spec);
// }
// }
// -----------------------------------------------------
// public class Mandolin extends Instrument {
// public Mandolin(String _serialNumber, double _price, MandolinSpec _spec) {
// super(_serialNumber, _price, _spec);
// }
// }