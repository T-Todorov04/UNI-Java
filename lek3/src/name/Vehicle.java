package name;

public class Vehicle {
    String brand;
    String date;
    String owner;
    double price;

    public Vehicle(String brand, String date, String owner, double price) {
        super();
        this.brand = brand;
        this.date = date;
        this.owner = owner;
        this.price = price;
    }
    public void honk(){
        System.out.println("Bip");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}