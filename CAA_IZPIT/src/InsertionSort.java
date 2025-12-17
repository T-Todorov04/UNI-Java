public class InsertionSort {
    public void sort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1; //1 елемент зад i

            // Move elements that are greater than `key` one position ahead
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Insert the `key` in its correct position
            array[j + 1] = key;
        }
    }
}
