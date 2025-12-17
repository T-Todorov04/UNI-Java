public abstract class Character {
    String name;
    int health;
    int power;
    String race;

    public Character(String name, int health, int power, String race) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.race = race;
    }

    public void attack(Monster target){
        if(target.health > 0){
            System.out.println(this.name +"("+this.health +") attacked "+ target.name+ "("+target.health+") for "+ this.power + " damage");
            target.health -= this.power;
        }else{
            System.out.println(target.name + " is dead");
        }

    }

    public void defend(int attackPower){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }


    public void introduce(){
        System.out.println("Hello my name is " +this.name +" and i am "+ this.race);
    }
}
