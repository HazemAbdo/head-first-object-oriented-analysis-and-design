package Chapter10;

import java.util.LinkedList;
import java.util.List;

public class Subway {
    private List<Station> stations;
    private List<Connection> connections;

    public Subway() {
        this.stations = new LinkedList<Station>();
        this.connections = new LinkedList<Connection>();
    }

    public boolean hasStation(String name) {
        // .contains documentation:
        // Returns true if this list contains the specified element.
        // More formally, returns true if and only if this list contains
        // at least one element e such that //* Objects.equals(o, e).
        // Parameters:o element whose presence in this list is to be tested
        // * so here comes the importance of overriding equals() and hashCode()
        // * in class Station
        // ----------------------------------------------------------------------
        // Normally, equals() in Java just checks to see
        // if two objects actually are the SAME object...
        // in other words, it looks to see if they are
        // actually both references to the same place in
        // memory. But that’s NOT what we want to use
        // for comparison of two Station objects
        // ----------------------------------------------------------------------
        // Lots of programmers would take station1Name,
        // and iterate through the list of stations in the Subway
        // class to find the Station object that has a name of
        // station1Name. But that takes a lot of time.
        if (stations.contains(new Station(name))) {
            return true;
        }
        return false;
    }

    public void addStation(String stationName) {
        if (!this.hasStation(stationName)) {
            stations.add(new Station(stationName));
        }
    }

    public void addConnection(String lineName, String station1, String station2) {

        if (this.hasStation(station1) && this.hasStation(station2)) {
            Station s1 = new Station(station1);
            Station s2 = new Station(station2);
            // ! This is VERY important. Since
            // ! Objectville subways run in
            // ! both directions, we add two
            // ! connections: one connection
            // ! for both directions.
            connections.add(new Connection(lineName, s1, s2));
            connections.add(new Connection(lineName, s2, s1));

        }
    }

    public boolean hasStation(Station s) {
        return stations.contains(s);
    }
}
