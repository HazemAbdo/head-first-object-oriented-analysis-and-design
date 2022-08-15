package Chapter5;

public enum InstrumentType {
    GUITAR, MANDOLIN, BANJO;

    public String toString() {
        switch (this) {
            case GUITAR:
                return "Guitar";
            case MANDOLIN:
                return "Mandolin";
            case BANJO:
                return "Banjo";
            default:
                return "";
        }
    }
}