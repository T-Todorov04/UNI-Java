package Main;

public class App {
    public static void main(String[] args) {

        Car car1 = new Car();
        car1.setBrand("brand1");
        car1.setModel("Model");
        car1.setYear(2024);
        car1.setPrice(29.99);

        Car car2 = new Car("brand2", "Model2", 1999, 20.11);

        System.out.println(car1.getBrand() + " " + car1.getModel() + " " + car1.getYear());
        System.out.println(car2.getBrand() + " " + car2.getModel() + " " + car2.getYear());

        Car[] cars = new Car[2];
        cars[0] = car1;
        cars[1] = car2;

        System.out.println(cars[1].getBrand() + " " + cars[1].getModel() + " " + cars[1].getYear());

        System.out.println(average(cars));
    }
        public static double average (Car[] cars){
            double result = 0.0;

            for (Car x : cars) {
                result += x.getPrice();
            }

            return result / cars.length;
        }

        //Car car1 = new Car();

        //System.out.println(car1.getBrand());
        //car1.setBrand("BMW");
        //System.out.println(car1.getBrand());

        //System.out.println(car1.year);

        //checkName(car1);
        //System.out.println(car1.getBrand());

        //sum(10, 5);
        //}
        //public static void checkName(Car car){
        //  car.setBrand("Opel");
        // System.out.println(car);
        //}
        //public static void sum(int y, int x){
        //  System.out.println(y + x);
        // }
    }
