package Chapter4;

//*delegation helps our applications stay loosely coupled. 
// That means that your objects are independent of each other; in other words, changes to one object
// don’t require you to make a bunch of changes to other objects
//---------
//* Delegation shields your objects from implementation changes to other objects in your software.
//------------------------------------------------------------------------------
//* some use case and class diagram stuff:
//* textual analysis.
// Looking at the nouns (and verbs) in your use case to figure out classes and methods is called 
//---------
//Maria’s figured out something really important: the nouns in a use case are usually the classes 
//you need to write and focus on in your system.
//---------
// The verbs in your use case are (usually) the methods of the objects in your system
//---------
//* Association:
// A solid line from one class(source) to another(target) is called an association. It means that one class is
// associated with another class, by //* reference, extension, inheritance, etc.
//---------
//* Multiplicity:
//This number is the multiplicity of this association. It’s how many of the target type is stored in
//the attribute of the source class. In this case, the door attribute stores a single DogDoor.

//------------------------------------------------------------------------------
//Here we have three engineers with three different ways to make a system that open the door based 
//on the barking of the dog.and the one with the most efficient system will win a MacBook pro.
//1.Randy: simple is best, right?
//Randy says that this operation is very simple and no need for OOP at all
//we will have a string represents the sound of our dog 
//and in the recognizer we will have a function that compare the heard voice(String) with our dog sound(String)
//if they are equal then we will open the door
//if they are not equal we will do nothing
//?where are the problems with this approach?
//!Randy didn't use any delegation so he make the recognizer responsible for the comparison
//what if we want the voice to be a more complex one for example Wav file and we will have a complex 
//compare function that will compare the heard voice with the Wav file
//!what if our dog have multiple sounds?
//all of these show that Randy didn't use a good approach.
//---------------------------------------------------------------------
// 2.Sam: object lover extraordinaire
//Sam make a Class called Bark that represent the sound of our dog and also make 
//the compare function that will compare the heard voice with the dog sound
//* so sam use delegation(Delegation ((((shields)))) your objects from implementation changes 
//to other objects in your software.)so if we change the formate then we will make no change to
//the recognizer Class
//?where are the problems with this approach?
//!what if our dog have multiple sounds?
//here Sam system doesn't handle this situation
//the problem is that sam didn't give that much attention to the use case so he focused on the wrong 
//thing he focus on bark not on the dog itself so he think if we handle case of one sound all is good
//---------------------------------------------------------------------
//3.Maria:Use case for rescue(she won the MacBook Pro!)
//maria focused on the use case and focus on the most important thing that is the dog itself not the bark
//so she make linked list of the dog sounds and make a compare function that will compare the heard voice with the dog sound
//* also maria make a class diagram to visualize the system and this help her to understand the system better
//and think in the //* real world context 

import java.util.Timer;
import java.util.TimerTask;
import java.util.LinkedList;

public class Chapter4 {
    public class Maria {
        public class DogDoor {
            private boolean open;
            private Integer delay;
            private LinkedList<Bark> barks;

            public DogDoor(Integer _delay, LinkedList<Bark> _barks) {
                this.open = false;
                this.delay = _delay;
                this.barks = _barks;
            }

            public void open() {
                System.out.println("The dog door opens.");
                open = true;
                // ----------------------------
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        close();
                        timer.cancel();
                    }
                }, delay);
                // ----------------------------
            }

            public void close() {
                System.out.println("The dog door closes.");
                open = false;
            }

            public boolean isOpen() {
                return open;
            }

            public void addAllowedBark(Bark bark) {
                barks.add(bark);
            }

            public LinkedList<Bark> getAllowedBarks() {
                return this.barks;
            }
        }

        // ---------------------------------------------------------------------------------
        public class Bark {
            private String sound;

            public Bark(String _sound) {
                this.sound = _sound;
            }

            public String getAllowedSound() {
                return this.sound;
            }

            public boolean equals(Object bark) {
                if (bark instanceof Bark) {
                    Bark otherBark = (Bark) bark;
                    if (this.sound.equalsIgnoreCase(otherBark.getAllowedSound())) {
                        return true;
                    }
                }
                return false;
            }

        }

        // ---------------------------------------------------------------------------------
        public class Remote {
            private DogDoor door;

            public Remote(DogDoor _door) {
                this.door = _door;
            }

            public void pressButton() {
                System.out.println("Pressing the remote control button...");
                if (this.door.isOpen()) {
                    this.door.close();
                } else {
                    this.door.open();
                }
            }
        }

        // ---------------------------------------------------------------------------------
        class BarkRecognizer {
            private DogDoor door;

            BarkRecognizer(DogDoor _door) {
                this.door = _door;
            }

            public void recognize(Bark recognizedBark) {
                System.out.println("BarkRecognizer: Heard a " + recognizedBark.getAllowedSound());
                for (Bark allowedBark : this.door.getAllowedBarks()) {
                    if (allowedBark.equals(recognizedBark)) {
                        System.out.println("BarkRecognizer: Matched " + allowedBark.getAllowedSound());
                        return;
                    }
                }
                System.out.println("BarkRecognizer: Bark did not match.");
            }
        }

        // ---------------------------------------------------------------------------------
        public class DogDoorSimulator {
            public static void main(String[] args) {
                DogDoor door = new Chapter4().new Maria().new DogDoor(5000, new LinkedList<Bark>());
                door.addAllowedBark(new Chapter4().new Maria().new Bark("rowlf"));
                door.addAllowedBark(new Chapter4().new Maria().new Bark("rooowlf"));
                door.addAllowedBark(new Chapter4().new Maria().new Bark("rawlf"));
                door.addAllowedBark(new Chapter4().new Maria().new Bark("woof"));
                BarkRecognizer recognizer = new Chapter4().new Maria().new BarkRecognizer(door);
                Remote remote = new Chapter4().new Maria().new Remote(door);
                // Simulate the hardware hearing a bark
                System.out.println("Bruce starts barking.");
                Bark heardBark = new Chapter4().new Maria().new Bark("rowlf");
                recognizer.recognize(heardBark);
                System.out.println("\nBruce has gone outside...");
                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                }
                System.out.println("\nBruce’s all done...");
                System.out.println("...but he’s stuck outside!");
                // Simulate the hardware hearing a bark (not Bruce!)
                Bark smallDogBark = new Chapter4().new Maria().new Bark("yip");
                System.out.println("A small dog starts barking.");
                recognizer.recognize(smallDogBark);
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                }
                // Simulate the hardware hearing a bark again
                System.out.println("Bruce starts barking.");
                heardBark = new Chapter4().new Maria().new Bark("rooowlf");
                recognizer.recognize(heardBark);
                System.out.println("\nBruce’s back inside...");
            }
        }
    }

    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    public class Sam {
        public class DogDoor {
            private boolean open;
            private Integer delay;
            private Bark bark;
            // !-------randy------
            private String sound;
            // !-------randy------

            public DogDoor(Integer _delay, Bark _bark) {
                this.open = false;
                this.delay = _delay;
                this.bark = _bark;
            }

            public void open() {
                System.out.println("The dog door opens.");
                open = true;
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        close();
                        timer.cancel();
                    }
                }, delay);
            }

            public void close() {
                System.out.println("The dog door closes.");
                open = false;
            }

            public boolean isOpen() {
                return open;
            }

            public Bark getAllowedBark() {
                return this.bark;
            }

            // ! -------randy------
            public String getAllowedSound() {
                return this.sound;
            }

            public void setAllowedSound(String _sound) {
                this.sound = _sound;
            }
            // ! -------randy------
        }

        // ---------------------------------------------------------------------------------
        public class Bark {
            private String sound;

            public Bark(String _sound) {
                this.sound = _sound;
            }

            public String getAllowedSound() {
                return this.sound;
            }

            // The details of how this comparison happens are
            // hidden from all the other objects in the dog door application.
            public boolean equals(Object bark) {
                if (bark instanceof Bark) {
                    Bark otherBark = (Bark) bark;
                    if (this.sound.equalsIgnoreCase(otherBark.getAllowedSound())) {
                        return true;
                    }
                }
                return false;
            }

        }

        // ---------------------------------------------------------------------------------
        public class Remote {
            private DogDoor door;

            public Remote(DogDoor _door) {
                this.door = _door;
            }

            public void pressButton() {
                System.out.println("Pressing the remote control button...");
                if (this.door.isOpen()) {
                    this.door.close();
                } else {
                    this.door.open();
                }
            }
        }

        // ---------------------------------------------------------------------------------
        class BarkRecognizer {
            private DogDoor door;

            BarkRecognizer(DogDoor _door) {
                this.door = _door;
            }

            public void recognize(Bark recognizedBark) {
                System.out.println("BarkRecognizer: Heard a " + recognizedBark.getAllowedSound());
                // BarkRecognizer to Bark:
                // Hey there, allowedBark. Can you see if this
                // other Bark that I have matches you? I really
                // don’t know much about what makes Barks the
                // same, but I’ll bet that you do
                if (this.door.getAllowedBark().equals(recognizedBark)) {
                    System.out.println("BarkRecognizer: Matched " + this.door.getAllowedBark().getAllowedSound());
                } else {
                    System.out.println("BarkRecognizer: Bark did not match.");
                }
            }

            // !-------randy------
            public void recog(String recognizedSound) {
                System.out.println("BarkRecognizer: Heard a " + recognizedSound);
                if (this.door.getAllowedSound().equalsIgnoreCase(recognizedSound)) {
                    System.out.println("BarkRecognizer: Matched " + this.door.getAllowedSound());
                } else {
                    System.out.println("BarkRecognizer: Bark did not match.");
                }
            }
            // !-------randy------
        }

    }
}
