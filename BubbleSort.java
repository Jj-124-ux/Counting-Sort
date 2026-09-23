public class BubbleSort {
    static long comparisons;                             // how many times two items were compared
    static long swaps;                                   // how many times two items were exchanged

    static void bubbleSort(int[] arr) {
        comparisons = 0;
        swaps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {               // each pass
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {       // compare neighbors
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];                  // swap them
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;                        // no swaps = already sorted
        }
    }
}

