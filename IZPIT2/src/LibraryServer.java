import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class LibraryServer {
    private static final int PORT = 5678;
    private static final Map<Integer, List<Book>> libraryBooks = new HashMap<>();

    public static void main(String[] args) {
        LibraryServer.addBook(new Book(1, "978-0134685991", "Effective Java", "Joshua Bloch", true, "Library A"));
        LibraryServer.addBook(new Book(2, "978-0596009205", "Head First Java", "Kathy Sierra", false, "Library B"));
        LibraryServer.addBook(new Book(3, "978-0321356680", "Java: The Complete Reference", "Herbert Schildt", true, "Library A"));

        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Listening on port " + PORT);
            ExecutorService threadPool = Executors.newFixedThreadPool(10);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                threadPool.submit(new ClientHandler());
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void addBook(Book book) {
        libraryBooks.computeIfAbsent(book.id, k-> new ArrayList<>()).add(book);
    }
    public static Map<Integer, List<Book>> getLibraryBooks() {
        return libraryBooks;
    }
}
