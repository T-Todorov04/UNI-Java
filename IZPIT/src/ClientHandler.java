import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    private static ConcurrentHashMap<String, List<Drink>> drinksDatabase = new ConcurrentHashMap<>();
    private static Map<Integer, Order> orders = new ConcurrentHashMap<>();
    private static int orderCounter = 1;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] parts = inputLine.split("\\|");
                int choice = Integer.parseInt(parts[0]);

                switch (choice) {
                    case 1:
                        checkAvailability(parts[1]);
                        break;
                    case 2:
                        submitRequest(parts[1]);
                        break;
                    case 3:
                        checkStatus(parts[1]);
                        break;
                    case 4:
                        restockBar(parts[1]);
                        break;
                    default:
                        out.println("Невалидна команда.");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void checkAvailability(String drinkName) {
        List<Drink> drinksList = drinksDatabase.get(drinkName);
        if (drinksList == null || drinksList.isEmpty()) {
            out.println("Напитката не е налична.");
            return;
        }

        StringBuilder response = new StringBuilder("Налични напитки:\n");
        for (Drink drink : drinksList) {
            response.append(drink.toString()).append("\n");
        }

        out.println(response.toString());
    }

    private void submitRequest(String drinkName) {
        try {
            int desiredDrinkID = Integer.parseInt(in.readLine());
            int desiredQuantity = Integer.parseInt(in.readLine());

            Order order = new Order(orderCounter++);
            order.addDrink(desiredDrinkID, desiredQuantity);
            order.setStatus("Нова");
            orders.put(order.getId(), order);

            out.println("Заявката е подадена: " + order);
        } catch (Exception e) {
            out.println("Грешка при въвеждане на ID и количество.");
        }
    }

    private void checkStatus(String orderIdStr) {
        try {
            int orderId = Integer.parseInt(orderIdStr);
            Order order = orders.get(orderId);
            if (order != null) {
                out.println("Статус на заявка " + orderId + ": " + order.getStatus());
            } else {
                out.println("Заявката не съществува.");
            }
        } catch (Exception e) {
            out.println("Грешен ID на заявка.");
        }
    }

    private void restockBar(String orderIdStr) {
        try {
            int orderId = Integer.parseInt(orderIdStr);
            Order order = orders.get(orderId);

            if (order != null && "Обработена".equals(order.getStatus())) {
                for (Map.Entry<Integer, Integer> entry : order.getDrinks().entrySet()) {
                    int drinkId = entry.getKey();
                    int quantity = entry.getValue();

                    for (List<Drink> drinksList : drinksDatabase.values()) {
                        for (Drink drink : drinksList) {
                            if (drink.getId() == drinkId) {
                                drink.addQuantity(quantity);
                            }
                        }
                    }
                }

                order.setStatus("Завършена");
                out.println("Барът е зареден със заявката " + orderId);
            } else {
                out.println("Заявката не е обработена или не съществува.");
            }
        } catch (Exception e) {
            out.println("Грешен ID на заявка.");
        }
    }

    private void closeConnection() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (clientSocket != null) clientSocket.close();
        } catch (Exception e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}