public enum Gender {
    MALE("nam"),
    FEMALE("nu"),
    OTHER("khac");

    String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
