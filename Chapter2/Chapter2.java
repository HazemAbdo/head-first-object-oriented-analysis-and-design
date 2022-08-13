package Chapter2;

//*  A Requirement is:
// It’s a specific thing your system has to do to work correctly
// the customer decides when a system works correctly
// A requirement is usually a ((single)) thing, and you can ((test)) that thing
//-----------------------------
//? sometimes even the customer doesn’t know what they really want!
//So you’ve got to ask the customer questions to figure out what they want 
//-----------------------------
//A good set of requirements goes beyond just what your customers tell you,
//and makes sure that the system works, even in unusual or unexpected circumstances.
//-----------------------------
// To make sure you have a good set of requirements, you should develop use cases for your system.
//-----------------------------
//* A use case
// describes ((what)) your system does to accomplish a particular customer goal
//in use case we don't think about how it works, we think about what it does
// One use case, three parts
//--------------------------
//1.clear value
//2.start and stop conditions
//3.External initiator
// As a general rule, your use cases should use simple, everyday language.
// !If you’re using lots of programming terms, or technical jargon
//-----------------------------
//Happy Path: Well, don’t get me wrong... things definitely go wrong in the real world. But when that 
//happens, I just hand things off to my buddy, //* Alternate Path.
//Happy Path:  My job is to take care of things when the sun is shining and things are 
//going just like people expect.
//-----------------------------------------------------------------------------------------
import java.util.Timer;
import java.util.TimerTask;

public class Chapter2 {
    public class DogDoor {
        private boolean open;

        public DogDoor() {
            this.open = false;
        }

        public void open() {
            System.out.println("The dog door opens.");
            open = true;
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

    // ---------------------------------------------------------------------------------
    public class DogDoorSimulator {
        public static void main(String[] args) {
            DogDoor door = new Chapter2().new DogDoor();
            Remote remote = new Chapter2().new Remote(door);
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