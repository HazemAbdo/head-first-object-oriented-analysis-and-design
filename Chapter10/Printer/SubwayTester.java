package Chapter10.Printer;

import java.io.File;
import java.util.List;

import Chapter10.Loader.SubwayLoader;
import Chapter10.Subway.Subway;

public class SubwayTester {
    public static void main(String[] args) {
        String source = "HTML Heights";
        String destination = "Objectville PizzaStore";
        try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville = loader.loadFromFile("Chapter10/Loader/Subway.txt");

            if (!objectville.hasStation(source)) {
                System.err.println(source + " is not a station in Objectville.");
                System.exit(-1);
            } else if (!objectville.hasStation(destination)) {
                System.err.println(destination + " is not a station in Objectville.");
                System.exit(-1);
            }
            List route = objectville.getDirections(source, destination);
            System.out.println(route.size() + " directions:");
            SubwayPrinter printer = new SubwayPrinter();
            printer.printDirections(route);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
