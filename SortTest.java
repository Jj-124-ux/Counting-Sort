import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] sizes = {5, 1_000, 1_000_000};
        Random rand = new Random(42);                   // same seed = same numbers every run

        for (int n : sizes) {
            int[] original = new int[n];
            for (int i = 0; i < n; i++) original[i] = rand.nextInt(1000);   // range 0-999

            System.out.println("Size " + n);
            if (n <= 10) System.out.println("  Before   : " + Arrays.toString(original));

            int k = rangeOf(original);                  // range of values used (max - min + 1)

            run("Counting ", original, 0, n, k);
            run("Bubble   ", original, 1, n, k);
            run("Selection", original, 2, n, k);
            run("Insertion", original, 3, n, k);
            System.out.println();
        }
    }

    static void run(String name, int[] original, int which, int n, int k) {
        int[] data = original.clone();                  // every sort gets a fresh copy

        long start = System.nanoTime();
        switch (which) {
            case 0 -> CountingSort.countingSort(data);
            case 1 -> BubbleSort.bubbleSort(data);
            case 2 -> SelectionSort.selectionSort(data);
            case 3 -> InsertionSort.insertionSort(data);
        }
        long ms = (System.nanoTime() - start) / 1_000_000;

        boolean ok = isSorted(data);
        long extraBytes = (which == 0 ? (long) n + k : 1) * 4;   // theoretical extra space in bytes (4 bytes per int)

        System.out.println("  " + name + ": " + ms + " ms  " + (ok ? "OK" : "WRONG")
                + "   " + metricsFor(which)
                + "   extra space ~ " + formatBytes(extraBytes));
        if (data.length <= 10) System.out.println("             " + Arrays.toString(data));
    }

    // Returns the comparison/swap (or movement, or array-access) counts for whichever sort just ran.
    static String metricsFor(int which) {
        return switch (which) {
            case 0 -> "array accesses = " + CountingSort.arrayAccesses + " (no comparisons/swaps, not a comparison sort)";
            case 1 -> "comparisons = " + BubbleSort.comparisons + "   swaps = " + BubbleSort.swaps;
            case 2 -> "comparisons = " + SelectionSort.comparisons + "   swaps = " + SelectionSort.swaps;
            default -> "comparisons = " + InsertionSort.comparisons + "   movements = " + InsertionSort.movements;
        };
    }

    static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " bytes";
        if (bytes < 1024 * 1024) return String.format("%.2f KB", bytes / 1024.0);
        return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
    }

    static int rangeOf(int[] arr) {
        return Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt() + 1;
    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}

