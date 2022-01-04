public class SchoolBook extends Library {
    private int pageNumber;
    private String status;
    private int borrowedNumber;

    public SchoolBook(String code, String name, String publishingCompany, int publishedYear, int quantity,
            int pageNumber, String status, int borrowedNumber) {
        super(code, name, publishingCompany, publishedYear, quantity);
        this.pageNumber = pageNumber;
        this.status = status;
        this.borrowedNumber = borrowedNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", pageNumber=" + pageNumber + ", borrowedNumber=" + borrowedNumber + ", status="
                + status;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getborrowedNumber() {
        return borrowedNumber;
    }

    public void setborrowedNumber(int borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }
}
