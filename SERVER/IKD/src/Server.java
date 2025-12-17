import java.io.IOException;
import java.net.ServerSocket;
import java.net.*;

public class Server {
    private static int port = 4567;
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            System.out.println("Server Error");
        }
    }
}
