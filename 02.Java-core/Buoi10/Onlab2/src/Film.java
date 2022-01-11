public class Film {
    private int id;
    private String title;
    private int length;
    private String category;
    private int view;
    private int year;

    public Film(int id, String title, int length, String category, int view, int year) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.category = category;
        this.view = view;
        this.year = year;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getView() {
        return this.view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", length='" + getLength() + "'" +
                ", category='" + getCategory() + "'" +
                ", view='" + getView() + "'" +
                ", year='" + getYear() + "'" +
                "}";
    }

}
