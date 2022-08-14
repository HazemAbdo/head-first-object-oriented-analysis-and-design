package Chapter2;

import java.util.Timer;
import java.util.TimerTask;

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
            // ----------------------------
            // * we add this functionality based on our requirements
            // * which we gather from our customers
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    door.close();
                    timer.cancel();
                }
            }, 5000);
            // ----------------------------
        }
    }
}