public class Person implements Printable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printDetails() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }

    public void introduce(){
        System.out.println("Hello my name is " + this.name + " and my age is " + this.age);
    }
}
