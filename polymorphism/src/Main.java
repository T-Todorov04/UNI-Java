public class Main {
    public static void main(String[] args) {
        var person1 = new Person("John Doe", 22);
        person1.introduce();

        var student1 = new Student("John Wick", 18,6);
        student1.introduce();

        System.out.println("-------");

        person1.printDetails();
        student1.printDetails();
    }
}