public class Student extends Person {
    double grade;
    public Student(String name, int age,double grade){
        super(name , age);
        this.grade = grade;
    }

    public void introduce(){
        System.out.println("Hello my name is " + this.name + " and my age is " + this.age + " and my grade is " + this.grade);
    }

    public void printDetails() {
        System.out.println("Name: " + this.name + ", Age: " + this.age + ", Grade: " + this.grade);
    }
}
