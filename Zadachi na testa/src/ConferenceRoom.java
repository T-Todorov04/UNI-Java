public class ConferenceRoom extends EventHall{
    private boolean projectorAvailable;

    public ConferenceRoom(String hallName, String location, int capacity, int availableSlots, double pricePerHour, boolean projectorAvailable) {
       super(hallName, location, capacity, pricePerHour,availableSlots);
       this.projectorAvailable = projectorAvailable;
    }
}
