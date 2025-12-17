public class Main {
    public static void main(String[] args) {
        BubbleSort bubbleSortOBJ = new BubbleSort();
        SelectionSort selectionSortOBJ = new SelectionSort();
        InsertionSort insertionSortOBJ = new InsertionSort(); //Assumes the first element is sorted
        int[] sortMeBro = {1,4,8,5,3,2,6,7,9};
        printArray(sortMeBro);


        //bubbleSortOBJ.sort(sortMeBro);
        //selectionSortOBJ.sort(sortMeBro);
        //insertionSortOBJ.sort(sortMeBro);

       printArray(sortMeBro);
    }



    public static void printArray(int[] array){
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}