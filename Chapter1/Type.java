package Chapter1;

// ? what we benefit from using enums
    // One of the big advantages of using enums is that it limits the possible
    // values you can supply to a method...no more misspellings or case issues.
    // * not only type safety, but value safety
   public enum Type {
        ACOUSTIC, ELECTRIC;

        public String toString() {
            switch (this) {
                case ACOUSTIC:
                    return "acoustic";
                case ELECTRIC:
                    return "electric";
                default:
                    return "unknown";
            }
        }
    }