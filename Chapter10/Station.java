package Chapter10;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // The Java specification recommends that if two objects
    // are equal, they should have the same hash code. So
    // if you’re deciding on equality based on a property, it’s
    // a good idea to also override hashCode() and return
    // a hash code based on that same property. This is
    // particularly important if you’re using your object in a
    // Hashtable or HashMap, which both make heavy use
    // of the hashCode() method.
    public boolean equals(Object o) {
        if (o instanceof Station) {
            Station s = (Station) o;
            return name.equalsIgnoreCase(s.getName());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

}
