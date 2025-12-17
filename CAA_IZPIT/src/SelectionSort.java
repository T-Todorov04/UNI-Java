public class SelectionSort {
    public void sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    array[j-1] = array[i];
                    array[i] = array[j];
                }
            }
        }
    }
}
