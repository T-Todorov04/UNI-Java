public abstract class Monster{
    String name;
    int health;
    int power;
    String race;

    public Monster(String name, int health, int power, String race) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.race = race;
    }

    public void attack(Character target){
        if(target.health > 0){
            System.out.println(this.name +"("+this.health +") attacked "+ target.name+ "("+target.health+") for "+ this.power + " damage");
            target.health -= this.power;
        }else{
            System.out.println(target.name + " is dead");
        }
    }
}
