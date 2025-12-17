import java.io.IOException;
import java.net.ServerSocket;
import java.net.*;

public class BarServer {
        private static final int port = 5678;
    public static void main(String[] args) {
        try(ServerSocket Socket = new ServerSocket(port)) {
            System.out.println("Connected to port " + port);

            while(true) {
                Socket clientSocket = Socket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
