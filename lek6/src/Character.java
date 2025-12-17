public abstract class Character {
     private int health;
     private int damage;
     private double attackSpeed;
     private String race;
     private String name;

     public Character(int health, int damage, double attackSpeed, String race, String name){ //constructor
         this.health = health;
         this.damage = damage;
         this.attackSpeed = attackSpeed;
         this.race = race;
         this.name = name;
     }
     public void introduce(){
         System.out.println("My race is " + race + " my name is "+ name);
     }

     public double getAttackSpeed(){
         return this.attackSpeed;
     }


     public void attack(Character defender){
         defender.defence(this.damage);
     }
     public void defence(int damage){
         this.health -= damage;
         System.out.println("Oooof, you fucker!!!");
     }
     public Boolean isAlive(){
         if(this.health > 0){
             return true;
         }else{
             return false;
         }
     }
}
