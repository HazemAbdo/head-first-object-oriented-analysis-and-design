package Chapter10.Subway;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class Subway {
    private List<Station> stations;
    private List<Connection> connections;
    // GetDirectionsPart
    private Map network;

    public Subway() {
        this.stations = new LinkedList<Station>();
        this.connections = new LinkedList<Connection>();
        this.network = new HashMap<>();
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

    // Why aren’t we just taking in a
    // Station object in addStation(),
    // and a Connection object in
    // addConnection()? Wouldn’t that
    // make sense?
    // ----------------------------------------------------------------------
    // If we went with your ideas, people that use the Subway class
    // would have to also work with Station and Connection.
    // Their code is getting tied in to how we
    // implement the Station and Connection classes, since they’re having to
    // work with those classes directly
    // Exactly! But with our version, we could change up Connection
    // or Station, and we’d only have to change our Subway class. Their
    // code would stay the same, since they’re abstracted away from our
    // implementations of Connection and Station
    // ----------------------------------------------------------------------
    // *You should only expose clients of your code to the
    // *classes that they NEED to interact with.
    // *Classes that the clients don’t interact with can be
    // *changed with minimal client code being affected.
    public void addStation(String stationName) {
        if (!this.hasStation(stationName)) {
            stations.add(new Station(stationName));
        }
    }

    public void addConnection(String station1, String station2, String lineName) {

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
            // GetDirectionsPart
            addToNetwork(s1, s2);
            addToNetwork(s2, s1);

        }
    }

    public boolean hasConnection(String station1, String station2, String lineName) {
        if (this.hasStation(station1) && this.hasStation(station2)) {
            Station s1 = new Station(station1);
            Station s2 = new Station(station2);
            if (connections.contains(new Connection(lineName, s1, s2))) {
                return true;
            }
        }
        return false;
    }

    // ---------------------------GetDirectionsPart-------------------------------------------
    private void addToNetwork(Station station1, Station station2) {
        if (network.keySet().contains(station1)) {
            List connectingStations = (List) network.get(station1);
            if (!connectingStations.contains(station2)) {
                connectingStations.add(station2);
            }
        } else {
            List connectingStations = new LinkedList();
            connectingStations.add(station2);
            network.put(station1, connectingStations);
        }
    }

    public List getDirections(String startStationName, String endStationName) {
        if (!this.hasStation(startStationName) ||
                !this.hasStation(endStationName)) {
            throw new RuntimeException(
                    "Stations entered do not exist on this subway.");
        }
        Station start = new Station(startStationName);
        Station end = new Station(endStationName);
        List route = new LinkedList();
        List reachableStations = new LinkedList();
        Map previousStations = new HashMap();
        List neighbors = (List) network.get(start);
        for (Iterator i = neighbors.iterator(); i.hasNext();) {
            Station station = (Station) i.next();
            if (station.equals(end)) {
                route.add(getConnection(start, end));
                return route;
            } else {
                reachableStations.add(station);
                previousStations.put(station, start);
            }
        }
        List nextStations = new LinkedList();
        nextStations.addAll(neighbors);
        Station currentStation = start;
        searchLoop: for (int i = 1; i < stations.size(); i++) {
            List tmpNextStations = new LinkedList();
            for (Iterator j = nextStations.iterator(); j.hasNext();) {
                Station station = (Station) j.next();
                reachableStations.add(station);
                currentStation = station;
                List currentNeighbors = (List) network.get(currentStation);
                for (Iterator k = currentNeighbors.iterator(); k.hasNext();) {
                    Station neighbor = (Station) k.next();
                    if (neighbor.equals(end)) {
                        reachableStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                        break searchLoop;
                    } else if (!reachableStations.contains(neighbor)) {
                        reachableStations.add(neighbor);
                        tmpNextStations.add(neighbor);
                        previousStations.put(neighbor, currentStation);
                    }
                }
            }
            nextStations = tmpNextStations;
        }
        // We’ve found the path by now
        boolean keepLooping = true;
        Station keyStation = end;
        Station station;
        while (keepLooping) {
            station = (Station) previousStations.get(keyStation);
            route.add(0, getConnection(station, keyStation));
            if (start.equals(station)) {
                keepLooping = false;
            }
            keyStation = station;
        }
        return route;
    }

    private Connection getConnection(Station station1, Station station2) {
        for (Iterator i = connections.iterator(); i.hasNext();) {
            Connection connection = (Connection) i.next();
            Station one = connection.getStation1();
            Station two = connection.getStation2();
            if ((station1.equals(one)) && (station2.equals(two))) {
                return connection;
            }
        }
        return null;
    }
}
