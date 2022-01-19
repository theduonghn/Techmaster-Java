package model;

import java.util.ArrayList;

public class Ebook extends Book {
    private int publishedYear;
    private double size;
    private String image;
    private int download;

    public Ebook(int id, String name, ArrayList<String> categories, String publishingCompany, int publishedYear,
                 double size, String image, int download) {
        super(id, name, categories, publishingCompany);
        this.publishedYear = publishedYear;
        this.size = size;
        this.image = image;
        this.download = download;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + publishedYear + " - " + size + " - " + image + " - " + download;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }
}
