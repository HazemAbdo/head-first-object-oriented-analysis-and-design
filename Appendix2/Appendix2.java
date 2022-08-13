package Appendix2;
public class Appendix2 {
    // -----------inheritance example---------------
    public class Airplane {
        // Encapsulation is when you hide the implementation of a
        // class in such a way that it is easy to use and easy to change. It
        // makes the class act as a black box that provides a service to its
        // users, but does not open up the code so someone can change
        // it or use it the wrong way. Encapsulation is a key technique in
        // being able to follow the //* Open-Closed principle.
        private int speed;

        public Airplane(int _speed) {
            this.speed = _speed;
        }

        public void setSpeed(int _speed) {
            this.speed = _speed;
        }

        // this is //* method overloading
        // same name but different parameters(different signatures)
        public void setSpeed(int _speed1, int _speed2) {
            this.speed = (_speed1 + _speed2) / 2;
        }

        public int geSpeed() {
            return this.speed;
        }
    }

    // That’s when one class inherits behavior from another
    // class, and can then change that behavior if needed
    public class Jet extends Airplane {
        private static final int MULT = 2;

        public Jet(int _speed) {
            super(_speed);
        }

        // A subclass can override its superclass’s behavior to change how a method
        // works //* (method overriding)
        // same signature as the superclass method but different implementation
        public void setSpeed(int _speed) {
            super.setSpeed(_speed * MULT);
        }

        public void accelerate() {
            super.setSpeed(geSpeed() * 2);
        }
    }

    // -----------inheritance example---------------
    public static void main(String[] args) {
        Appendix2 app = new Appendix2();
        Jet jet = app.new Jet(100);
        Airplane airplane = app.new Airplane(100);
        // Polymorphism is closely related to inheritance. When
        // one class inherits from another, then polymorphism allows a
        // * subclass to stand in for the superclass
        Airplane airplane2 = app.new Jet(100);
        airplane.setSpeed(100);
        airplane2.setSpeed(100);
        System.out.println(airplane.geSpeed());
        System.out.println(airplane2.geSpeed());
        jet.accelerate();
        System.out.println(jet.geSpeed());
    }
}
