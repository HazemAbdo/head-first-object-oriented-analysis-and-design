package Chapter1;

public enum StringNum {
    FIVE, SIX, SEVEN, EIGHT, NINE, TWELVE;

    public Integer toInteger() {
        switch (this) {
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TWELVE:
                return 12;
            default:
                return 5;
        }
    }
}