package Chapter8;

//Single Responsibility Principle
//Apply SRP(single responsibility principle) Test:
//DO The Automobile starts itself
//DO The Automobile stops itself
//DONOT The Automobile changes tires itself
//DONOT The Automobile changes oil itself
//DONOT The Automobile drives itself
//DONOT The Automobile washes itself
//DO The Automobile gets oil itself
//Once you’ve done an analysis, you can take all the methods
//that don’t make sense on a class, and move those methods to
//classes that do make sense for that particular responsibility
//------------------------------------
// then we will keep start,stop,and getOilLevel in the Automobile class
//we will move drive to the class Driver
//we will move changeTires to the class Mechanic
//we will move changeOil to the class Mechanic
//we will move wash to the class Washer
public class Automobile {
    private float oilLevel;

    public void start() {
        System.out.println("Starting the car");
    }

    public void stop() {
        System.out.println("Stopping the car");
    }

    public void changeTires() {
        System.out.println("Changing the tires");
    }

    public void checkOil() {
        System.out.println("Changing the oil");
    }

    public void drive() {
        System.out.println("Driving the car");
    }

    public void wash() {
        System.out.println("Washing the car");
    }

    public float getOilLevel() {
        return oilLevel;
    }
}
