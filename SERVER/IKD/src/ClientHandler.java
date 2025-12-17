import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static ConcurrentHashMap<String, List<Drink>> barDataBase = new ConcurrentHashMap<>();
    ArrayList<orderMustHaves> Orders = new ArrayList<>();

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);


            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                String[] parts = inputLine.split("\\|");

                int choice = Integer.parseInt(parts[0]);

                switch (choice) {
                    case 1:
                        checkAvailability();
                        break;
                    case 2:
                        submitOrder(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                        break;
                    case 3:
                         checkOrders();
                         break;
                    case 4:
                         restock();
                         break;
                }
            }

        } catch (IOException e) {
            out.println("Error");
        }finally{
            closeConnection();
        }
    }

        private void checkAvailability(){
            for(Map.Entry<String, List<Drink>> item : barDataBase.entrySet()){
                for (Drink drink : item.getValue()) {
                    if(drink.getQuantity() > 0){
                        out.println(drink.getID() + " " + drink.getName()+" "+drink.getQuantity() + " " + drink.getType());
                    }else{
                        out.println(drink.getID() + " is run out");
                    }
                }
            }
        }

        private void submitOrder(int id, int quantity){
            orderMustHaves newOrder = new orderMustHaves(id,quantity,"Sent");
            Orders.add(newOrder);
        }

        private void checkOrders(){
            for(orderMustHaves order : Orders){
                out.println(Orders.indexOf(order) + " "+ order.orderID+" "+ order.orderQuantity+" "+ order.Status);
            }
        }

        private void restock(){
            for(orderMustHaves order : Orders){
                if(order.Status != "Done"){
                    for(Map.Entry<String, List<Drink>> item : barDataBase.entrySet()){
                        for (Drink drink : item.getValue()) {
                            if(order.orderID == drink.getID()){
                                drink.quantity += order.orderQuantity;
                            }
                        }
                    }
                }
            }
        }
        private void closeConnection(){
            try{
                if(out != null) out.close();
                if(in != null) in.close();
                if(clientSocket != null) clientSocket.close();
            }catch (IOException e){
                out.println("Error");
       }
    }
}
