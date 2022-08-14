package Chapter3;

import java.util.Timer;
import java.util.TimerTask;

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