package Chapter4;
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
}
