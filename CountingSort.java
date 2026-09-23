import java.util.Arrays;

public class CountingSort {
    static long arrayAccesses;                            // count sort has no comparisons/swaps;
    // this tracks array reads/writes instead

    static void countingSort(int[] arr) {
        arrayAccesses = 0;
        if (arr.length == 0) return;

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max - min + 1];
        int[] output = new int[arr.length];

        for (int num : arr) {                            // 1. count each number
            count[num - min]++;
            arrayAccesses++;
        }

        for (int i = 1; i < count.length; i++) {         // 2. running total
            count[i] += count[i - 1];                     //    = final position of each number
            arrayAccesses++;
        }

        for (int i = arr.length - 1; i >= 0; i--) {       // 3. place each item, going backwards
            output[--count[arr[i] - min]] = arr[i];        //    (backwards keeps equal items in order = stable)
            arrayAccesses++;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);  // 4. copy the result back into arr
        arrayAccesses += arr.length;                        // arraycopy does 1 write per item
    }
}

