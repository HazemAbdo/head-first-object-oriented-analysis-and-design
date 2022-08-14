package Chapter5;

public enum InstrumentType {
    GUITAR, MANDOLIN;

    public String toString() {
        switch (this) {
            case GUITAR:
                return "Guitar";
            case MANDOLIN:
                return "Mandolin";
            default:
                return "";
        }
    }
}