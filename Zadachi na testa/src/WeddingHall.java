public class WeddingHall extends EventHall {
    private boolean bridalSuiteIncluded;
    public WeddingHall(String hallName, String location, int capacity, double pricePerHour, int availableSlots,boolean bridalSuiteIncluded) {
        super(hallName, location, capacity, pricePerHour, availableSlots);
        this.bridalSuiteIncluded = bridalSuiteIncluded;
    }
}
