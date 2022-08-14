package Chapter3;

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