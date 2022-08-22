package Chapter10.Subway;

public class Connection {
    private String lineName;
    private Station station1;
    private Station station2;

    public Connection(String lineName, Station station1, Station station2) {
        this.lineName = lineName;
        this.station1 = station1;
        this.station2 = station2;
    }

    public String getLineName() {
        return lineName;
    }

    public Station getStation1() {
        return station1;
    }

    public Station getStation2() {
        return station2;
    }

    public boolean equals(Object o) {
        if (o instanceof Connection) {
            Connection c = (Connection) o;
            return lineName.equalsIgnoreCase(c.getLineName()) &&
                    station1.equals(c.getStation1()) &&
                    station2.equals(c.getStation2());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return lineName.toLowerCase().hashCode() +
                station1.hashCode() + station2.hashCode();
    }

}
