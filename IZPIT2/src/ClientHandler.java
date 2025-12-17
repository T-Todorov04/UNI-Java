import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    @Override
    public void run() {
        try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage = in.readLine();

            while((clientMessage = in.readLine()) != null) {
                if(clientMessage.equalsIgnoreCase("EXIT")) {
                    break;
                }
                handleClientRequest(clientMessage);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                clientSocket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private void handleClientRequest(String request){
        Map<Integer, List<Book>> books = LibraryServer.getLibraryBooks();

        if(request.equalsIgnoreCase("GET ALL BOOKS")){
            for(List<Book> bookList : books.values()){
                for(Book book : bookList){
                    out.println(book.toString());
                }
            }
        }else{
            out.println("INVALID COMMAND");
        }
    }
}
