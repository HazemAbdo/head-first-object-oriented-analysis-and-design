package Chapter10;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class SubwayLoader {
    private Subway subway;

    public SubwayLoader(Subway subway) {
        this.subway = subway;
    }

    public void loadFromFile(String filePath) {
        int emptyLinesCounter = 0;
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (emptyLinesCounter == 0) {
                    Station s = new Station(data);
                    if (!subway.hasStation(s)) {
                        subway.addStation(s);
                    }
                }
                else
                {
                    if(data.contains("line"))
                    {
                        
                    }
                }
                // check if current line is empty
                if (data.isEmpty()) {
                    emptyLinesCounter++;
                }
            }
            myReader.close();
        } catch (

        FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
