public class Drink {
    int ID;
    String Name;
    String Type;
    int Quantity;


    public Drink(int ID, String name, String type, int quantity) {
        this.ID = ID;
        Name = name;
        Type = type;
        Quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}