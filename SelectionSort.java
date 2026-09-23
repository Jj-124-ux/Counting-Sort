public class SelectionSort {
    static long comparisons;                             // how many times two items were compared
    static long swaps;                                   // how many times two items were exchanged

    static void selectionSort(int[] arr) {
        comparisons = 0;
        swaps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {               // i = the spot we're filling
            int minIndex = i;                           // assume the spot's own number is smallest

            for (int j = i + 1; j < n; j++) {           // scan the rest of the line
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;                       // found a smaller one, remember where
                }
            }

            int temp = arr[i];                          // swap smallest into spot i
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            swaps++;                                     // one swap per pass, even if minIndex == i
        }
    }
}

