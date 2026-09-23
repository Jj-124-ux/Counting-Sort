public class InsertionSort {
    static long comparisons;                             // how many times two items were compared
    static long movements;                                // how many times an item was shifted

    static void insertionSort(int[] arr) {
        comparisons = 0;
        movements = 0;

        for (int i = 1; i < arr.length; i++) {          // i = the new card we just picked up
            int key = arr[i];                           // hold it in your hand
            int j = i - 1;

            while (j >= 0) {
                comparisons++;                          // compare key against the card at j
                if (arr[j] <= key) break;               // found where key belongs, stop
                arr[j + 1] = arr[j];                    // slide the bigger card one spot right
                movements++;
                j--;
            }

            arr[j + 1] = key;                           // drop the card in the gap
        }
    }
}

