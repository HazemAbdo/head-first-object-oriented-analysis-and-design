package Chapter2;

public class Chapter2 {
    public class DogDoorSimulator {
        public static void main(String[] args) {
            DogDoor door = new DogDoor();
            Remote remote = new Remote(door);
            System.out.println("Fido barks to go outside.");
            remote.pressButton();
            System.out.println("Fido has gone outside.");
            System.out.println("Fido all done.");
            // ! what about that alternate path, when Fido stays outside
            // ! and the door closes behind him
            try {
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
            }
            System.out.println("Fido starts barking again.");
            System.out.println("but he's still outside.");
            System.out.println("so todd grabs the remote and press the button.");
            remote.pressButton();
            System.out.println("Fido has gone inside.");

        }
    }

}