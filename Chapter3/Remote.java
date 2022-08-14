package Chapter3;

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