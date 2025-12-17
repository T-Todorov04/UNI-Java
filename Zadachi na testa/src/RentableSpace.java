public interface RentableSpace {
    boolean rentSpace(int n) throws NoAvailableException;
}
class NoAvailableException extends Exception {
    public NoAvailableException(String message) {
        super(message);
    }
}