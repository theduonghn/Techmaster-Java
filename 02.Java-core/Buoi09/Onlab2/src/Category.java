public enum Category {
    DO_GIA_DUNG("Do gia dung"), THUC_PHAM("Thuc pham"), THOI_TRANG("Thoi trang");

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
