public class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area(){
        return this.width * this.height;
    }
    public double perimeter(){
        return 2 * (this.width + this.height);
    }

    public double halfArea(){
        return this.area() / 2;
    }

}
