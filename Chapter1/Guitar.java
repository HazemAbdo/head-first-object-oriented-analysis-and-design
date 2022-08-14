package Chapter1;

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