package sorting.counting;

import java.util.Arrays;

public class RadixSort {
    /** Radix Sort. Assume the number of digits in each key is the same.  */
    public static void radixSort(Elem[] arr) {
        if (arr.length == 0)
            return;
        // First, compute the number of digits in each key
        // Since we assume they all have the same # of digits,
        // it's enough to compute the # of digits in the first key
        int ndigits = (int) (Math.log10(arr[0].getKey()) + 1);

        Elem[] result = new Elem[arr.length];  // temporary array to hold the result
        int[] count = new int[10]; // count array for counting sort

        for (int i = 0, place = 1; i < ndigits; i++, place *= 10) {
            // place will be 1, then 10, then 100, then 1000, etc.
            // when place is 1, we are sorting by the last digit, when place is 10, we are sorting by the last to last digit etc.

            // Initialize count array - reset values to 0
            for (int j = 0; j < 10; j++)
                count[j] = 0;
            // iterate over arr and fill out the count array
            for (int j = 0; j < arr.length; j++) {
                int currentDigit = (arr[j].getKey() / place) % 10;
                count[currentDigit]++;

                // Compute the current "key" - the digit on which we are sorting
                // Go to the bin for that digit and increment the count
            }

            for (int j = 1; j < 10; j++) {
                // Modify count array by creating cumulative counts
                count[j] = count[j] + count[j - 1];

            }

            // Fill the result array in sorted order
            for (int j = arr.length - 1; j >= 0; j--) {
               // Access the key and the digit of the key that is currently used for sorting,
                // use it as an index in the counter array to find the cumulative count
                // Use it as the index of arr[i] in the result array
                int key = arr[j].getKey();
                int currentDigit = (key / place) % 10;
                count[currentDigit]--;
                result[count[currentDigit]] = arr[j];

            }

            // copy the result back into arr before repeating steps for the next digit
            for (int j = 0; j < arr.length; j++)
                arr[j] = result[j];
        }
    }

    public static void main(String[] args) {
        Elem[] elements = {
                new Elem(456, "A"), new Elem(308, "B"),
                new Elem(207, "C"), new Elem(405, "D"),
                new Elem(301, "E"), new Elem(123, "F"),
                new Elem(198, "E"), new Elem(883, "F"),

        };
        radixSort(elements);
        System.out.println(Arrays.toString(elements));
    }

}

