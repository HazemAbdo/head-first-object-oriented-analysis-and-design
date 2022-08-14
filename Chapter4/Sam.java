package Chapter4;

import java.util.Timer;
import java.util.TimerTask;

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