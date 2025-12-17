import java.net.*;

public class BarServer {
    private static final int port = 5678;

    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Waiting for connection...");
            System.out.println("Waiting for client...");
            System.out.println("Connection established");

            while(true){
                Socket clientSocket = serverSocket.accept();

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
