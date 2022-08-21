package Chapter10;

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
        return this.station1;
    }

    public Station getStation2() {
        return station2;
    }

}
