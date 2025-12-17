public class Book {
    int id;
    String ISBN;
    String title;
    String author;
    boolean availability;
    String library;

    public Book(int id, String ISBN, String title, String author, boolean availability, String library) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.availability = availability;
        this.library = library;
    }

    public String toString() {
        return "ID: " + id + ", ISBN: " + ISBN + ", Title: " + title + ", Author: " + author + ", Availability: " + (availability ? "Available" : "Not Available") + ", Library: " + library;
    }
}
