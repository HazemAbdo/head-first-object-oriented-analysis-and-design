
// The one constant in software analysis and design is //* CHANGE
//-----
// should be what you want to have happen most of the time.-->//* The main path
//-----
// A complete path through a use case, from the first step to the last, is called a //* scenario.\
//-----
//Even though I was part of the use case, I wasn’t part of the most common scenarios-->//* Alternate Path
//-----
//You should almost always try to avoid duplicate code. It’s a maintenance nightmare, and usually points 
//to problems in how you’ve designed your system//* (DRY)
import java.util.Timer;
import java.util.TimerTask;

public class Chapter3 {
    public class DogDoor {
        private boolean open;
        private Integer delay;

        public DogDoor(Integer _delay) {
            this.open = false;
            this.delay = _delay;
        }

        public void open() {
            System.out.println("The dog door opens.");
            open = true;
            // ----------------------------
            // Well, closing the door is really
            // something that the door should
            // do, not the remote control or the
            // BarkRecognizer. Why don’t we have the
            // DogDoor close itself?
            // !DRY(Don't Repeat Yourself)
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
                // !DRY(Don't Repeat Yourself)
                // final Timer timer = new Timer();
                // timer.schedule(new TimerTask() {
                // public void run() {
                // door.close();
                // timer.cancel();
                // }
                // }, door.delay);
            }
        }
    }

    // ---------------------------------------------------------------------------------
    class BarkRecognizer {
        private DogDoor door;

        BarkRecognizer(DogDoor _door) {
            this.door = _door;
        }

        // ? But what happens if a dog other than Fido is barking?
        // Hmmm... our bark recognizer isn’t really “recognizing” a bark, is it? It’s
        // opening the door for ANY bark. We may have to come back to this later
        public void recognize(String bark) {
            System.out.println("BarkRecognizer: Heard a " + bark);
            door.open();
            // !DRY(Don't Repeat Yourself)
            // final Timer timer = new Timer();
            // timer.schedule(new TimerTask() {
            // public void run() {
            // door.close();
            // timer.cancel();
            // }
            // }, door.delay);
        }
    }

    // ---------------------------------------------------------------------------------
    public class DogDoorSimulator {
        public static void main(String[] args) {
            DogDoor door = new Chapter3().new DogDoor(5000);
            BarkRecognizer recognizer = new Chapter3().new BarkRecognizer(door);
            Remote remote = new Chapter3().new Remote(door);
            // Simulate the hardware hearing a bark
            System.out.println("Fido starts barking.");
            recognizer.recognize("Woof");
            System.out.println("\nFido has gone outside...");
            System.out.println("\nFido’s all done...");
            try {
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
            }
            System.out.println("...but he’s stuck outside!");
            // Simulate the hardware hearing a bark again
            System.out.println("Fido starts barking.");
            recognizer.recognize("Woof");
            System.out.println("\nFido’s back inside...");
        }
    }

}