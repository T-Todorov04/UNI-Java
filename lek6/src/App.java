public class App {
    public static void main(String[] args) {
        var orc = new Orc("Ivancho");
        var human = new Human("Michael");

        battle(orc, human);
    }

    public static void battle(Character char1, Character char2) {
        double counter = 0;


        while(char1.isAlive() && char2.isAlive()){
            if(counter % char1.getAttackSpeed()*10 ==0){

            }

            char1.attack(char2);
            if(char2.isAlive()){
                char2.attack(char1);
            }



            Thread.sleep(100);
            counter+=0.1;
        }

        if(char1.isAlive()){
            System.out.println("Char1 is alive");
        }else{
            System.out.println("Char2 is alive");
        }
    }

}
