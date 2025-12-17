package Zad1;

import java.util.Stack;

public class Train {
    private Stack<String> wagons;

    public Train() {
        wagons = new Stack<>();
    }

    // Метод за добавяне на вагон
    public void push(String wagon) {
        wagons.push(wagon);
        System.out.println("Вагон \"" + wagon + "\" е добавен.");
    }

    // Метод за премахване на последния вагон
    public String pop() {
        if (!wagons.isEmpty()) {
            String removedWagon = wagons.pop();
            System.out.println("Вагон \"" + removedWagon + "\" е премахнат.");
            return removedWagon;
        } else {
            System.out.println("Няма повече вагони за премахване!");
            return null;
        }
    }

    // Метод за извеждане на всички вагони
    public void display() {
        if (wagons.isEmpty()) {
            System.out.println("Влакът е празен.");
        } else {
            System.out.println("Текущи вагони: " + wagons);
        }
    }
}