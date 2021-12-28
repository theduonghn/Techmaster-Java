public enum DogSize {
    LARGE("large"),
    MEDIUM("medium"),
    SMALL("small"),
    TINY("tiny");

    public String value;

    private DogSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
