package Chapter9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Unit {
    private String unitType;
    private String name;
    private List<Weapon> weapons;
    private Integer ID;
    private Map<String, Object> properties;

    public Unit(Integer id) {

        ID = id;
    }

    public void addWeapon(Weapon weapon) {
        // We wait until there’s a
        // need for a weapons list to
        // instantiate a new List. That
        // saves a little bit of memory,
        // especially when there may be
        // thousands of units.
        if (this.weapons == null) {
            this.weapons = new LinkedList<Weapon>();
        }
        this.weapons.add(weapon);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public void setProperty(String propertyName, Object propertyValue) {
        // Just like the weapons List, we
        // don’t create a HashMap for
        // properties until it’s needed.
        if (properties == null) {
            properties = new HashMap<String, Object>();
        }
        properties.put(propertyName, propertyValue);
    }

    // ------------------------------------------------------------------------------
    // Q: Why are you throwing a RuntimeException, and not a
    // checked exception, like IllegalAccessException?
    // A: If you used a checked exception, code that calls
    // getProperty() would have to check for that exception, in
    // try/catch blocks. That’s not what the client wanted; we agreed
    // to a contract that would let them code without having to catch for
    // any exceptions. So by using a RuntimeException, no extra
    // worked is required for their client code to use the Unit class
    public Integer getId() {
        return ID;
    }

    public String getName() {
        if (name == null) {
            throw new RuntimeException("Name not set");
        }
        return name;
    }

    public List<Weapon> getWeapons() {
        if (weapons == null) {
            throw new RuntimeException("Weapons not set");
        }
        return weapons;
    }

    public String getUnitType() {
        if (unitType == null) {
            throw new RuntimeException("Unit type not set");
        }
        return unitType;
    }

    public Object getProperty(String propertyName) {
        if (properties == null) {
            throw new RuntimeException("Properties not set");
        }
        if (!properties.containsKey(propertyName)) {
            throw new IllegalArgumentException("Property not found");
        }
        return properties.get(propertyName);
    }
}
