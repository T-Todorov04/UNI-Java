public abstract class EventHall implements RentableSpace{
    String hallName;
    String location;
    int capacity;
    int availableSlots;
    double pricePerHour;

    public EventHall(String hallName, String location, int capacity, double pricePerHour, int availableSlots) {
        this.hallName = hallName;
        this.location = location;
        this.capacity = capacity;
        this.pricePerHour = pricePerHour;
        this.availableSlots = availableSlots;
    }

    public boolean rentSpace(int slots) throws NoAvailableException {
        if (slots <= availableSlots) {
            availableSlots -= slots;
            return true;
        } else {
            throw new NoAvailableException("Недостатъчно налични места в залата.");
        }
    }
}
