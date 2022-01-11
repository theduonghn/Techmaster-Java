package model;

public enum Category {
    HOUSEHOLD("Do gia dung"), FOOD("Thuc pham"), FASHION("Thoi trang");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
