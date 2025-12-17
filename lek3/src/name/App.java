package name;
public class App {
    public static void main(String[] args) {
        Car car1 = new Car("Gas", "BMW", "2005-09-11", "Ivan", 2);
        Car car2 = new Car("Diesel", "VW", "2001-09-11", "Toshko", 9999999.99);
        Car car3 = new Car("Electric", "Tesla", "2005-09-11", "Ivan", 9090);
        Car car4 = new Car("Diesel", "Opel", "2001-09-11", "Toshko", 1);

        Car[] cars = {car1, car2, car3, car4};
        car3.moreExpensiveCar(cars);
    }

}