public class Main {
    public static void main(String[] args) {
        var conferenceHall1 = new ConferenceRoom("Ivan Vazov", "east building", 500, 4, 120.40, false);
        var weddingHall1 = new WeddingHall("Gorchivo", "west building", 400, 3, 5,true);

        try {
            conferenceHall1.rentSpace(1);
            System.out.println("Резервацията е успешна");
        } catch (NoAvailableException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        try{
            weddingHall1.rentSpace(500);
            System.out.println("Успешма регистрация");
        }catch (NoAvailableException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        System.out.println("kura mi qnko");
    }
}