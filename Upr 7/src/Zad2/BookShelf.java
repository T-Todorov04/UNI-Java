package Zad2;
import java.util.LinkedList;
import java.util.Queue;

public class BookShelf {
    private Queue<String> books;

    // Конструктор
    public BookShelf() {
        books = new LinkedList<>();
    }

    // Метод за добавяне на книга в края на опашката
    public void addBook(String book) {
        books.add(book);
        System.out.println("Книгата \"" + book + "\" е добавена на рафта.");
    }

    // Метод за взимане на книга от началото на опашката
    public String takeBook() {
        if (!books.isEmpty()) {
            String removedBook = books.poll();
            System.out.println("Книгата \"" + removedBook + "\" е взета от рафта.");
            return removedBook;
        } else {
            System.out.println("Рафтът е празен!");
            return null;
        }
    }

    // Метод за показване на текущите книги на рафта
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Рафтът е празен.");
        } else {
            System.out.println("Книги на рафта: " + books);
        }
    }
}