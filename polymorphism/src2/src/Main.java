public class Main {
    public static void main(String[] args) {
        var circle1 = new Circle(4.12);
        System.out.println("Circle's area is " + String.format("%.1f",circle1.area()));
        System.out.println("Circle's perimeter is " + String.format("%.1f",circle1.perimeter()));
        System.out.println("Circle's half area is " + String.format("%.1f",circle1.halfArea()));

        System.out.println("=------------------------=");

        var rectangle1 = new Rectangle(1.0000001, 2.14);
        System.out.println("Rectangle's area is " + String.format("%.1f",rectangle1.area()));
        System.out.println("Rectangle's perimeter is " + String.format("%.1f",rectangle1.perimeter()));
        System.out.println("Rectangle's half area is " + String.format("%.1f",rectangle1.halfArea()));
    }
}