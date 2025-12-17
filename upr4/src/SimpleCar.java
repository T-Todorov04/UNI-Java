import java.util.Objects;

interface Refuelable {
    void refuel();
}

abstract class Vehicle {
    int speed;
    int MAX_SPEED = 50;
    int MIN_SPEED = 0;

    public Vehicle(int initialSpeed) {
        this.speed = initialSpeed;
    }

    public abstract void accelerate();
    public abstract void brake();
}

class ElectricCar extends Vehicle implements Refuelable{
    int battery;
    public ElectricCar(int initialSpeed, int battery) {
        super(initialSpeed);
        this.battery = battery;
        this.speed = initialSpeed;
    }
    public void accelerate() {
        battery--;
        if(battery > 0) {
            if (this.speed < MAX_SPEED) {
                this.speed += 10;
                if (this.speed > MAX_SPEED) {
                    this.speed = MAX_SPEED;
                }
                System.out.print("Speed after accelerate: " + this.speed);
                System.out.println(", Battery left: " + this.battery );
            } else {
                System.out.println("Speed after accelerate: " + this.speed);
            }

        }else{
            System.out.println("Battery empty!");
        }
    }
    public void brake() {
        if (this.speed > MIN_SPEED) {
            this.speed -= 20;
        }
        if(this.speed < 0){
            this.speed = 0;
        }
        System.out.println("Speed after brake: " + this.speed);
    }
    public void refuel() {
        battery += 20;
        System.out.println("Car refueled, Battery left: " + this.battery);
    }
}

class SimpleCar extends Vehicle  implements Refuelable{
    int fuel;
    public SimpleCar(int initialSpeed, int fuel) {
        super(initialSpeed);
        this.speed = initialSpeed;
        this.fuel = fuel;
    }

    public void accelerate() {
        fuel--;
        if(fuel > 0) {
            if (this.speed < MAX_SPEED) {
                this.speed += 10;
                if (this.speed > MAX_SPEED) {
                this.speed = MAX_SPEED;
            }
                System.out.print("Speed after accelerate: " + this.speed);
                System.out.println(", Fuel left: " + this.fuel );
            } else {
                System.out.println("Speed after accelerate: " + this.speed);
            }

        }else{
            System.out.println("Out of fuel!");
        }
    }

    public void brake() {
        if (this.speed > MIN_SPEED) {
            this.speed -= 20;
        }
        if(this.speed < 0){
            this.speed = 0;
        }
        System.out.println("Speed after brake: " + this.speed);
    }
    public void refuel() {
        fuel += 10; // Refuel by 10 liters
        System.out.println("SimpleCar refueled, Fuel left: " + this.fuel);
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            int initialSpeed = Integer.parseInt(args[1]);
            int fuel = Integer.parseInt(args[2]);
            SimpleCar car = new SimpleCar(initialSpeed, fuel);
            ElectricCar car2 = new ElectricCar(initialSpeed, fuel);
            //car.accelerate();
            //car.refuel();

            //car2.accelerate();
            //car2.refuel();

            String carType = args[0];
            int speedNew = Integer.parseInt(args[1]);

            if (Objects.equals(carType, "SimpleCar")){
                int fuelNew = Integer.parseInt(args[2]);
                SimpleCar carNew = new SimpleCar(speedNew, fuelNew);
                System.out.println("This is SimpleCar");
                carNew.refuel();
            }else if(Objects.equals(carType, "ElectricCar")){
                int batteryNew = Integer.parseInt(args[2]);
                ElectricCar carNew = new ElectricCar(speedNew, batteryNew);
                System.out.println("This is ElectricCar");
                carNew.refuel();
            }else{
                System.out.println("Error, no car type found");
            }




            //car.brake();
            //car.brake();
            //car.brake();
        }
    }
}

