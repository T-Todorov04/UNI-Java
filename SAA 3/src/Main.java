/*public class Main {
    public static void main(String[] args) {
        int[][] lst = {{ 1, 2, -3},
                       { 4, 5,  6},
                       {-7, 8,  9}};

        int sumOtherThanDiagonal = 0;
        int sumDiagonal = 0; //-10

        int sumDiagonal2 = 0;
        int sumAll = 0;



        for (int i = 0; i < lst.length; i++) {
            if (lst[i][lst.length - i - 1] < 0) {
                sumDiagonal += lst[i][lst.length - i - 1];
            }
        }
        System.out.println(sumDiagonal);

        for (int i = 0; i < lst.length; i++) {
            for (int j = 0; j < lst.length; j++) {
                if (i == j) {
                    if(lst[i][j] % 2 == 0){
                    sumDiagonal2 += lst[i][j];
                    }
                }
                if(lst[i][j] % 2 == 0){
                    sumAll += lst[i][j];
                }

            }
        }
        System.out.println(sumDiagonal2);
        System.out.println(sumAll);

        int sum2 = sumAll - sumDiagonal2;
        System.out.println(sum2);


        System.out.println("Краен отговор е " + (sum2 + sumDiagonal));
    }
}
 */
public class Main{
    public static void main(String[] args) {
        int num = 2;
        int power = 5;
        int counter = 0;
        while(counter != power){
            num*=power
        }
        System.out.println(num);
    }
}