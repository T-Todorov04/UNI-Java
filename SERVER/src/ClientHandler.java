import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public  class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static ConcurrentHashMap<String, List<Drink>> barDataBase = new ConcurrentHashMap<>();
    ArrayList<requirementsForOrder> allOrders = new ArrayList<>();

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    public void run(){
        try{
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] parts = inputLine.split("\\|");

                int choice = Integer.parseInt(parts[0]);

                switch (choice) {
                    case 1:
                        checkAvailability();
                        break;
                    case 2:
                        int desiredID;
                        int desiredQuantity;
                        try{
                             desiredID = Integer.parseInt(in.readLine());
                             desiredQuantity = Integer.parseInt(in.readLine());
                        }catch (Exception e){
                            out.println("Please enter a valid ID and quantity");
                            return;
                        }
                        makeOrder(desiredID, desiredQuantity);
                        break;
                    case 3:
                        checkOrders();
                        break;
                    case 4:
                        restockBar();
                        break;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
    }

    private void checkAvailability(){
        for (Map.Entry<String, List<Drink>> entry : barDataBase.entrySet()) {
            for (Drink drink : entry.getValue()) {
                if(drink.getQuantity() <= 0){
                    out.println(drink.getID() + "not available");
                }else{
                    System.out.println("Drink ID: " + drink.getID());
                }
            }
        }
    }

    private void makeOrder(int desiredID, int desiredQuantity){
        requirementsForOrder newOrder = new requirementsForOrder();
        newOrder.ID = desiredID;
        newOrder.Quantity = desiredQuantity;
        newOrder.Status = "Not ready";
        allOrders.add(newOrder);
    }
    private void checkOrders(){
        for(requirementsForOrder order : allOrders){
            out.println(order.ID + ": " + order.Quantity+" "+order.Status);
        }
    }
    private void restockBar(){
        for(requirementsForOrder order : allOrders){
            if(order.Status == "Ready"){
                for (Map.Entry<String, List<Drink>> entry : barDataBase.entrySet()){
                    for (Drink drink : entry.getValue()){
                        if(drink.getID() == order.ID){
                            drink.Quantity += order.Quantity;
                        }
                    }
                }
            }
        }
    }
    private void closeConnection(){
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (clientSocket != null) clientSocket.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
