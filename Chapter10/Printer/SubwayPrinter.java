package Chapter10.Printer;

import java.io.PrintStream;
import java.util.List;

import Chapter10.Subway.Connection;

public class SubwayPrinter {
    public void printDirections(List<Connection> directions) {
        for (Connection c : directions) {
            System.out.println("Go from " + c.getStation1().getName() + " to " + c.getStation2().getName() + " on the "
                    + c.getLineName() + " line" + " then\n");
        }
    }
}
