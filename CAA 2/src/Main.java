public class Main {
    public static void main(String[] args) {

        // Едномерен масив
        // Да се намери сумата от произведенията на всеки 2 елемента участващи в съседни двойки от елементи
        // 1-2 2-3 3-4
//        int[] arr = {1, 2, 3, 4};
//        int sumOfProducts = 0;
/*
        for (int i = 0; i < arr.length-1; i++) {
            sumOfProducts += arr[i] * arr[i+1];
        }
        System.out.println(sumOfProducts);
*/
 /*
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                sumOfProducts += arr[i] * arr[j];
            }
        }
        System.out.println(sumOfProducts);
*/
        //Да се намери броят и дължината на площатките (2 елемента еднакви един до дръг)
/*
        int[] arr = {1, 2, 2, 2, 3, 3,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,};
        int same = 1;
        int amount = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                same++;
            } else {
                System.out.println(arr[i] + " се повтаря " + same + " пъти.");
                same = 1;
                amount++;
            }
        }
        System.out.println(arr[arr.length - 1] + " се повтаря " + same + " пъти.");
        System.out.println("Броят на площадките е " + amount);
 */
        //Двимерен маси, сума на вс елементи покрай краяищата
/*
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == arr.length - 1) {
                for (int j = 0; j < arr[i].length; j++) {
                    sum += arr[i][j];
                }
            }else{
                sum+=arr[i][0] + arr[i][arr[i].length-1];
            }
        }
        System.out.println(sum);
 */
        //Двумерен масив, да се състави едномерен масив със вследните елементи - 1ви сумата на - елементи по главния диагонал, последния елемент е броят на нечетните по стойност елементи намиращи се под главния диагоналм, останалите са сумите  след първия и преди последния са сумата на редовете на двумерния масив

        int[][] matrix = {
                         {-1, 2, 3},
                         { 4,-5, 6},
                         { 7, 8, -9}
                         };
        int negative = 0;
        int[] arr = new int[5];
        //Първи елемент
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][i] < 0){
                negative += matrix[i][i];
            }
        }
        arr[0] = negative;

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            arr[i+1] = sum;
        }
        int sumOdd = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == j){
                    break;
                }else{
                    if (matrix[i][j] % 2 != 0){
                        sumOdd += matrix[i][j];
                    }
                }
            }
        }
        arr[4] = sumOdd;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}