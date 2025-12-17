public class App {
    public static void main(String[] args) {
        var paladin = new Paladin("John Wick");
        var amazon = new Amazon("Diana");
        var barb = new Barbarian("Joe");
        var necro = new Necromancer("Baba Yaga");


        //paladin.introduce();
        //amazon.introduce();
        //barb.introduce();
        //necro.introduce();


        var enemy = new FallenShaman("Mr Evil");


        Battle(barb,enemy);
        System.out.println("   ");
        Battle(amazon,enemy);

    }
    public static void Battle(Character fighter1, Monster fighter2) {
        int initialHealth1 = fighter1.health;
        int initialHealth2 = fighter2.health;
        boolean Battle = true;
        while (Battle) {
            if(fighter1.health>0 && fighter2.health > 0){
                fighter1.attack(fighter2);
                if(fighter2.health > 0) {
                    fighter2.attack(fighter1);
                }
            }else{
                Battle = false;
                if (fighter1.health <= 0){
                    System.out.println(fighter2.name + " has won");
                }
                if(fighter2.health <= 0){
                    System.out.println(fighter1.name + " has won");
                }
            }
        }
        fighter1.health = initialHealth1;
        fighter2.health = initialHealth2;
    }
}
