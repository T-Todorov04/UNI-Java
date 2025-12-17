package name;

public class Car extends Vehicle {
    String engineType;
    public Car(String engineType, String brand, String date, String owner, double price) {
        super(brand,date,owner,price);
        this.engineType = engineType;
    }
    public void moreExpensiveCar(Car[] cars) {
        for(Car car : cars) {
            if (car.price > this.price){
                System.out.println(car.brand + " is more expensive than " + this.brand);
            }else{
                System.out.println(this.brand + " is more expensive than " + car.brand);
            }
        }
    }
}