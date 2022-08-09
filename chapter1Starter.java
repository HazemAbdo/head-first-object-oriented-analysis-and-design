//TODOs:
// 1.Make sure your software does what the customer wants it to do
//[ ]he never get a guitar
//[ ]use enums
//[ ]get rid of case sensitivity problems
//----------------------------------------------------------------
// 2.Apply basic OO principles to add flexibility
//Unused properties are a dead giveaway.
//we never used price or serialNumber in searching
//[ ]encapsulate properties
//----------------------------------------------------------------
// 3.Strive for a maintainable, reusable design.
//add number of strings to your system
//[ ]use delegation so that whenever you add new properties
// you don't have to change the code in many classes
//----------------------------------------

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class chapter1Starter {
    public class Guitar {
        private String serialNumber, builder, model, type, backWood, topWood;
        private double price;

        public Guitar(String serialNumber, double price,
                String builder, String model, String type,
                String backWood, String topWood) {
            this.serialNumber = serialNumber;
            this.price = price;
            this.builder = builder;
            this.model = model;
            this.type = type;
            this.backWood = backWood;
            this.topWood = topWood;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double newPrice) {
            this.price = newPrice;
        }

        public String getBuilder() {
            return builder;
        }

        public String getModel() {
            return model;
        }

        public String getType() {
            return type;
        }

        public String getBackWood() {
            return backWood;
        }

        public String getTopWood() {
            return topWood;
        }
    }

    public class Inventory {
        private List guitars;

        public Inventory() {
            guitars = new LinkedList();
        }

        public void addGuitar(String serialNumber, double price,
                String builder, String model,
                String type, String backWood, String topWood) {
            Guitar guitar = new Guitar(serialNumber, price, builder,
                    model, type, backWood, topWood);
            guitars.add(guitar);
        }

        public Guitar getGuitar(String serialNumber) {
            for (Iterator i = guitars.iterator(); i.hasNext();) {
                Guitar guitar = (Guitar) i.next();
                if (guitar.getSerialNumber().equals(serialNumber)) {
                    return guitar;
                }
            }
            return null;
        }

        public Guitar search(Guitar searchGuitar) {
            for (Iterator i = guitars.iterator(); i.hasNext();) {
                Guitar guitar = (Guitar) i.next();
                // Ignore serial number since that’s unique
                // Ignore price since that’s unique
                String builder = searchGuitar.getBuilder();
                if ((builder != null) && (!builder.equals("")) &&
                        (!builder.equals(guitar.getBuilder())))
                    continue;
                String model = searchGuitar.getModel();
                if ((model != null) && (!model.equals("")) &&
                        (!model.equals(guitar.getModel())))
                    continue;
                String type = searchGuitar.getType();
                if ((type != null) && (!searchGuitar.equals("")) &&
                        (!type.equals(guitar.getType())))
                    continue;
                String backWood = searchGuitar.getBackWood();
                if ((backWood != null) && (!backWood.equals("")) &&
                        (!backWood.equals(guitar.getBackWood())))
                    continue;
                String topWood = searchGuitar.getTopWood();
                if ((topWood != null) && (!topWood.equals("")) &&
                        (!topWood.equals(guitar.getTopWood())))
                    continue;
            }
            return null;
        }
    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("V95693", 1599.95, "Fender", "Stratocaster",
                "electric", "Alder", "Alder");
        inventory.addGuitar("V9512", 1599.95, "Fender", "Stratocaster",
                "electric", "Alder", "Alder");
        inventory.addGuitar("V95693", 1599.95, "Fender", "Stratocaster",
                "electric", "Alder", "Alder");
    }

    public class FindGuitarTester {
        public static void main(String[] args) {
            // Set up Rick’s guitar inventory
            Inventory inventory = new chapter1Starter().new Inventory();
            initializeInventory(inventory);
            Guitar whatErinLikes = new chapter1Starter().new Guitar("", 0, "fender", "Stratocastor",
                    "electric", "Alder", "Alder");
            Guitar guitar = inventory.search(whatErinLikes);
            if (guitar != null) {
                System.out.println("Erin, you might like this " +
                        guitar.getBuilder() + " " +
                        guitar.getModel() + " " +
                        guitar.getType() + " " +
                        guitar.getBackWood() + " " +
                        guitar.getTopWood() + " guitar:\n" +
                        guitar.getSerialNumber() + " " +
                        guitar.getPrice());
            } else {
                System.out.println("Sorry, Erin, we have nothing for you.");
            }
        }
    }

}
