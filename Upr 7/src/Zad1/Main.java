package Zad1;

public class Main {
    public static void main(String[] args) {
            Train train = new Train();
            train.push("Вагон 1");
            train.push("Вагон 2");
            train.push("Вагон 3");
            train.display();
            train.pop();
            train.display();
            train.pop();
            train.pop();
            train.pop(); // Ще покаже, че няма повече вагони
    }
}