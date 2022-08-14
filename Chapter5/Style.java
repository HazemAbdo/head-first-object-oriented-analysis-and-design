package Chapter5;
public enum Style {
    A, B, C;

    public String toString() {
        switch (this) {
            case A:
                return "A";
            case B:
                return "B";
            case C:
                return "C";
            default:
                return "unknown";
        }
    }
}