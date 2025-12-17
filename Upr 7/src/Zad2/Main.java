package Zad2;

public class Main {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        shelf.addBook("Книга 1");
        shelf.addBook("Книга 2");
        shelf.addBook("Книга 3");
        shelf.displayBooks();
        shelf.takeBook();
        shelf.displayBooks();
        shelf.takeBook();
        shelf.takeBook();
        shelf.takeBook(); // Ще покаже, че рафтът е празен
    }
}
