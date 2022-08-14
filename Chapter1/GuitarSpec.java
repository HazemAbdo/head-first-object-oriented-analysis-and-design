package Chapter1;

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

    boolean areSimilarGuitars(GuitarSpec spec2) {
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