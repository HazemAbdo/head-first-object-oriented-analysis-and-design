package Chapter5;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Spec {
    // When you have a set of properties that vary
    // across your objects, use a collection, like a Map,
    // to store those properties dynamically.
    private Map<String, Object> properties;

    public Spec(Map<String, Object> properties) {
        if (properties == null) {
            this.properties = new HashMap<String, Object>();
        } else {
            this.properties = properties;
        }
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public boolean matches(Spec otherSpec) {
        for (Iterator i = otherSpec.getProperties().keySet().iterator(); i.hasNext();) {
            String PropertyName = (String) i.next();
            System.out.println("PropertyName: " + PropertyName);
            System.out.println(this.getProperty(PropertyName));
            System.out.println(otherSpec.getProperty(PropertyName));
            if (!this.getProperty(PropertyName).equals(otherSpec.getProperty(PropertyName))) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (String key : properties.keySet()) {
            if (key != "instrumentType") {
                System.out.println(key + ": " + properties.get(key));
            }
        }
    }

    // private Builder builder;
    // private Type type;
    // private Wood backWood, topWood;
    // private String model;

    // public Spec(String _model, Builder _builder, Type _type, Wood _backWood, Wood
    // _topWood) {
    // this.model = _model;
    // this.builder = _builder;
    // this.type = _type;
    // this.backWood = _backWood;
    // this.topWood = _topWood;
    // }

    // public Builder getBuilder() {
    // return builder;
    // }

    // public String getModel() {
    // return model;
    // }

    // public Type getType() {
    // return type;
    // }

    // public Wood getBackWood() {
    // return backWood;
    // }

    // public Wood getTopWood() {
    // return topWood;

    // }

    // private boolean matches(Spec spec2) {
    // if (this.getBuilder() != spec2.getBuilder()) {
    // return false;
    // }
    // if (!this.getModel().toLowerCase().equals(spec2.getModel().toLowerCase())) {
    // return false;
    // }
    // if (this.getType() != spec2.getType()) {
    // return false;
    // }
    // if (this.getBackWood() != spec2.getBackWood()) {
    // return false;
    // }
    // if (this.getTopWood() != spec2.getTopWood()) {
    // return false;
    // }
    // return true;
    // }
}

// -----------------------------------------------------------
// public class GuitarSpec extends Spec {
// private StringNum numStrings;

// public GuitarSpec(String _model, Builder _builder, Type _type, Wood
// _backWood, Wood _topWood,
// StringNum _numStrings) {
// super(_model, _builder, _type, _backWood, _topWood);
// this.numStrings = _numStrings;
// }

// public StringNum getNumStrings() {
// return numStrings;
// }

// private boolean matches(GuitarSpec spec2) {
// if (!super.matches(spec2)) {
// return false;
// }
// if (!(spec2 instanceof GuitarSpec)) {
// return false;
// }
// GuitarSpec spec = (GuitarSpec) spec2;
// if (this.getNumStrings() != spec.getNumStrings()) {
// return false;
// }
// return true;
// }
// }

// // -----------------------------------------------------------
// public class MandolinSpec extends Spec {
// private Style style;

// public MandolinSpec(String _model, Builder _builder, Type _type, Wood
// _backWood, Wood _topWood,
// Style _style) {
// super(_model, _builder, _type, _backWood, _topWood);
// this.style = _style;
// }

// public Style getStyle() {
// return style;
// }

// private boolean matches(MandolinSpec spec2) {
// if (!super.matches(spec2)) {
// return false;
// }
// if (!(spec2 instanceof MandolinSpec)) {
// return false;
// }
// MandolinSpec spec = (MandolinSpec) spec2;
// if (this.getStyle() != spec.getStyle()) {
// return false;
// }
// return true;
// }
// }